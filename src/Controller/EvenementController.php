<?php

namespace App\Controller;

use App\Entity\Evenement;

use App\Form\EvenementType;

use App\Repository\EvenementRepository;
use App\Repository\ReservationRepository;
use App\Repository\UserRepository;
use Doctrine\ORM\EntityManagerInterface;
use Dompdf\Dompdf;
use Dompdf\Options;
use Knp\Component\Pager\PaginatorInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\File\UploadedFile;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\IsGranted;

/**
 * @Route("/evenement")
 */
class EvenementController extends AbstractController
{


    /**
     * @IsGranted("ROLE_EVENT")
     * @Route("/", name="evenement_index", methods={"GET","POST"})
     */
    public function index(Request $request,PaginatorInterface $paginator){
        $em=$this->getDoctrine()->getManager();
        $data=$em->getRepository(Evenement::class)->findAll();
        $evenements=$paginator->paginate($data,$request->query->getInt('page',1),3);

        if($request->isMethod("POST")){
            $name=$request->get('NameEvent');
            $data=$em->getRepository( Evenement::class)->findBy(array('NameEvent'=>$name));
            $evenements=$paginator->paginate($data,$request->query->getInt('page',1),3);

        }
        return $this->render('Back/evenement/index.html.twig',array('evenements'=>$evenements));
    }

    /**
     * @IsGranted("ROLE_EVENT")
     * @Route("/pdf", name="evenement_pdf", methods={"GET"})
     */
    public function index_pdf(EvenementRepository $evenementRepository, Request $request)
    {
        $pdfoptions=new Options();
        $pdfoptions->set('defaultFont','Arial');
        $dompdf=new dompdf();
        $evenements=$evenementRepository->findAll();

        $html=$this->renderView('Back/evenement/printevent.html.twig', [
            'evenements' => $evenements,
        ]);
       $dompdf->loadHtml($html);
       $dompdf->setPaper('A4','portrait');
       $dompdf->render();
       $dompdf->stream('mypdf.pdf',["Attachement" => true]);

    }
    /**
     * @IsGranted("ROLE_EVENT")
     * @Route("/calendar", name="calendar", methods={"GET","POST"})
     */
    public function calendar(EvenementRepository $evenementRepository){

        $events=$evenementRepository->findAll();
        $rdvs= [];
        foreach ($events as $event){
            $rdvs[]=[

                'NameEvent'=>$event->getNameEvent(),
                'PlaceEvent'=> $event->getPlaceEvent(),
                'DateDebut'=>$event->getDateDebut()->format('Y-m-d ,h:m'),
                'DateFin'=>$event->getDateFin()->format('Y-m-d ,h:m'),
            ];

        }
        //dd($rdvs);
        $data=json_encode($rdvs);
        //dd($data);
        return $this->render('Back/evenement/calendar.html.twig',compact('data'));

    }


        /**
         * @IsGranted("ROLE_EVENT")
         * @Route("/new", name="evenement_new", methods={"GET", "POST"})
         */
        public function new(Request $request, EntityManagerInterface $entityManager): Response
    {
        $evenement = new Evenement();
        $form = $this->createForm(EvenementType::class, $evenement);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            //$file=$form->get('ImageEvent')->getData();
           /// $upload_directory=$this->getParameter('upload_directory');
           // $filename=md5(uniqid().'.'.$file->guessExtension());
          //  $file->move($upload_directory,$filename);
           // $evenement->setImageEvent($filename);
            $entityManager->persist($evenement);
            $entityManager->flush();

            return $this->redirectToRoute('evenement_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('Back/evenement/new.html.twig', [
            'evenement' => $evenement,
            'form' => $form->createView(),
        ]);
    }
    /**
     * @IsGranted("ROLE_EVENT")
     * @Route("/sort", name="sort")
     */
    public function TrierParPrix(Request $request,PaginatorInterface $paginator): Response
    {
        $repository = $this->getDoctrine()->getRepository(Evenement::class);
        $event = $repository->findByPrice();
        //$event=$em->getRepository(Evenement::class)->findAll();
        $evenements=$paginator->paginate($event,$request->query->getInt('page',1),3);
        return $this->render('Back/evenement/index.html.twig', [
            'evenements' => $evenements,
        ]);
    }


    /**
     * @IsGranted("ROLE_PLAYER")
     * @Route("/front", name="evenement_index2", methods={"GET"})
     */
    public function front(PaginatorInterface $paginator,Request $request)
    {
        $event=$this->getDoctrine()->getRepository(Evenement::class)->findAll();
        $evenements=$paginator->paginate($event,$request->query->getInt('page',1),3);
        return $this->render('Front/evenement/indexfront.html.twig', [
            'evenements' => $evenements,
        ]);
    }


    /**
     * @IsGranted("ROLE_EVENT")
     * @Route("/{id}", name="evenement_show", methods={"GET"})
     */
    public function show(Evenement $evenement): Response
    {
        return $this->render('Back/evenement/show.html.twig', [
            'evenement' => $evenement,
        ]);
    }
    /**
     * @IsGranted("ROLE_PLAYER")
     * @Route("/front/{id}", name="evenement_show_front", methods={"GET"})
     */
    public function showfront(Evenement $evenement): Response
    {
        return $this->render('Front/evenement/show.html.twig', [
            'evenement' => $evenement,
        ]);
    }

    /**
     * @IsGranted("ROLE_EVENT")
     * @Route("/{id}/edit", name="evenement_edit", methods={"GET", "POST"})
     */
    public function edit(Request $request, Evenement $evenement, EntityManagerInterface $entityManager): Response
    {
        $form = $this->createForm(EvenementType::class, $evenement);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->flush();

            return $this->redirectToRoute('evenement_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('Back/evenement/edit.html.twig', [
            'evenement' => $evenement,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @IsGranted("ROLE_EVENT")
     * @Route("/{id}/delete", name="evenement_delete")
     */
    public function delete(EvenementRepository $repo, $id)
    {
        $event = $repo->find($id);
        $em = $this->getDoctrine()->getManager();
        $em->remove($event);
        $em->flush();

        return $this->redirectToRoute('evenement_index', [], Response::HTTP_SEE_OTHER);
    }



}
