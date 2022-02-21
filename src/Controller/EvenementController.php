<?php

namespace App\Controller;

use App\Entity\Evenement;
use App\Entity\Recherche;

use App\Form\EvenementType;
use App\Form\NameEventSearchType;

use App\Repository\EvenementRepository;
use App\Repository\ReservationRepository;
use Doctrine\DBAL\Types\TextType;
use Doctrine\ORM\EntityManagerInterface;
use Dompdf\Dompdf;
use Dompdf\Options;
use Knp\Component\Pager\PaginatorInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\Form\Extension\Core\Type\SearchType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/evenement")
 */
class EvenementController extends AbstractController
{

    /**
     * @Route("/", name="evenement_index", methods={"GET","POST"})
     */
    public function index(Request $request,PaginatorInterface $paginator){
        $em=$this->getDoctrine()->getManager();
        $event=$em->getRepository(Evenement::class)->findAll();
        $evenements=$paginator->paginate($event,$request->query->getInt('page',1),3);

        if($request->isMethod("POST")){
            $name=$request->get('NameEvent');
            $event=$em->getRepository( Evenement::class)->findBy(array('NameEvent'=>$name));
        }
        return $this->render('Back/evenement/index.html.twig',array('evenements'=>$evenements));
    }
    /**
     * @Route("/listEventsWithSearch", name="listEventsWithSearch")
     */
    public function listStudentWithSearch(Request $request, EvenementRepository $repository)
    {
        $evenements=$repository->findAll();

        //search
        $searchForm = $this->createForm(NameEventSearchType::class);
       // $searchForm->add("Search", SubmitType::class);
        $searchForm->handleRequest($request);
        if ($searchForm->isSubmitted()) {
            $NameEvent = $searchForm['NameEvent']->getData();
            $resultOfSearch = $repository->SearchEvent($NameEvent);
            return $this->render('Back/evenement/search.html.twig', [
                'resultOfSearch'=>$resultOfSearch ,
                'searchEvent' => $searchForm->createView(),
                ]);
        }
        return $this->render('Back/evenement/index.html.twig', [
            'evenements' => $evenements,
        ]);
    }
    /**
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
         * @Route("/new", name="evenement_new", methods={"GET", "POST"})
         */
        public function new(Request $request, EntityManagerInterface $entityManager): Response
    {
        $evenement = new Evenement();
        $form = $this->createForm(EvenementType::class, $evenement);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
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
     * @Route("/sort", name="sort")
     */
    public function TrierParPrix(Request $request): Response
    {
        $repository = $this->getDoctrine()->getRepository(Evenement::class);
        $evenements = $repository->findByPrice();

        return $this->render('Back/evenement/index.html.twig', [
            'evenements' => $evenements,
        ]);
    }
    /**
     * @Route("/front", name="evenement_index2", methods={"GET"})
     */
    public function front(EvenementRepository $evenementRepository)
    {
        $evenements=$this->getDoctrine()->getRepository(Evenement::class)->findAll();

        return $this->render('Front/evenement/indexfront.html.twig', [
            'evenements' => $evenements,
        ]);
    }
    /**
     * @Route("/{id}", name="evenement_show", methods={"GET"})
     */
    public function show(Evenement $evenement): Response
    {
        return $this->render('Back/evenement/show.html.twig', [
            'evenement' => $evenement,
        ]);
    }

    /**
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
