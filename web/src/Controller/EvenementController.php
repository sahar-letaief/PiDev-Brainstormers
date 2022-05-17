<?php

namespace App\Controller;

use App\Entity\Evenement;

use App\Form\EvenementType;

use App\Repository\EvenementRepository;
use App\Repository\ReservationRepository;
use App\Repository\UserRepository;
use App\Services\QrcodeService;
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
use Symfony\Component\Serializer\Normalizer\NormalizerInterface;

/**
 * @Route("/evenement")
 */
class EvenementController extends AbstractController
{



    /**
     * @IsGranted("ROLE_EVENT")
     * @Route("/", name="evenement_index", methods={"GET","POST"})
     */
    public function index(Request $request,PaginatorInterface $paginator,EvenementRepository $evenementRepository){
        $em=$this->getDoctrine()->getManager();
        $data=$em->getRepository(Evenement::class)->findAll();
        $evenements=$paginator->paginate($data,$request->query->getInt('page',1),3);
        $back = null;
        if($request->isMethod("POST")){
            if ( $request->request->get('optionsRadios')){
                $SortKey = $request->request->get('optionsRadios');
                switch ($SortKey){
                    case 'NameEvent':
                        $events = $evenementRepository->SortByNameEvent();
                        break;

                    case 'PriceEvent':
                        $events = $evenementRepository->SortByPriceEvent();
                        break;

                    case 'NbParticipants':
                        $events = $evenementRepository->SortByParticipants();
                        break;

                }
            }
            else
            {
                $type = $request->request->get('optionsearch');
                $value = $request->request->get('Search');
                switch ($type){
                    case 'NameEvent':
                        $events = $evenementRepository->findByNameEvent($value);
                        break;

                    case 'PlaceEvent':
                        $events = $evenementRepository->findByPlaceEvent($value);
                        break;

                    case 'DateDebut':
                        $events = $evenementRepository->findByDateDebut($value);
                        break;

                    case 'DateFin':
                        $events = $evenementRepository->findByDateFin($value);
                        break;


                }
            }
            if ( $events){
                $back = "success";
            }else{
                $back = "failure";
            }
            //dd($request->request->get('optionsRadios'));
            $evenements=$paginator->paginate(
                $events,
                $request->query->getInt('page',1),
                3);

            return $this->render('evenement/index.html.twig',array('evenements'=>$evenements, 'back'=>$back));

        }
        return $this->render('evenement/index.html.twig',array('evenements'=>$evenements, 'back'=>$back));
    }
    /**
     * @Route("/newApi", name="evenement_new_api")
     */
    public function newjson(Request $request,NormalizerInterface $normalizer){
        $em=$this->getDoctrine()->getManager();
        $e=new Evenement();

        $e->setNameEvent($request->get('NameEvent'));
        $e->setPlaceEvent($request->get('PlaceEvent'));
        $e->setPriceEvent($request->get('PriceEvent'));
        $e->setNbParticipants($request->get('NbParticipants'));
        $e->setDateDebut(new \DateTime($request->get('DateDebut')));
        $e->setDateFin(new \DateTime($request->get('DateFin')));
        //dd($e);
        $em->persist($e);
        $em->flush();
        $jsonContent=$normalizer->normalize($e,'json',['groups'=>'post:read']);
        return new Response(json_encode($jsonContent));

    }

    /**
     * @Route("/apiDisplay", name="evenement_index_api")
     */
    public function indexjson(NormalizerInterface $Normalizer) : Response
    {
        $evenements=$this->getDoctrine()->getRepository(Evenement::class)->findAll();
        $jsonContent=$Normalizer->normalize($evenements,'json',['groups'=>'post:read']);
        return new Response(json_encode($jsonContent));
    }
    /**
     * @Route("/apiSortPrice", name="evenement_sortprice_api")
     */
    public function sortjsonPrice(NormalizerInterface $Normalizer) : Response
    {
        $evenements=$this->getDoctrine()->getRepository(Evenement::class)->SortByPriceEvent();
        $jsonContent=$Normalizer->normalize($evenements,'json',['groups'=>'post:read']);
        return new Response(json_encode($jsonContent));
    }
    /**
     * @Route("/apiSortPart", name="evenement_sortpart_api")
     */
    public function sortjsonPart(NormalizerInterface $Normalizer) : Response
    {
        $evenements=$this->getDoctrine()->getRepository(Evenement::class)->SortByParticipants();
        $jsonContent=$Normalizer->normalize($evenements,'json',['groups'=>'post:read']);
        return new Response(json_encode($jsonContent));
    }
    /**
     * @Route("/apiSortName", name="evenement_sortname_api")
     */
    public function sortjsonName(NormalizerInterface $Normalizer) : Response
    {
        $evenements=$this->getDoctrine()->getRepository(Evenement::class)->SortByParticipants();
        $jsonContent=$Normalizer->normalize($evenements,'json',['groups'=>'post:read']);
        return new Response(json_encode($jsonContent));
    }

    /**
     * @Route("/deleteApi/{id}", name="evenement_delete_api")
     */
    public function deletejson(Request $request, $id,NormalizerInterface $normalizer)
    {
        $em = $this->getDoctrine()->getManager();
        $event=$em->getRepository(Evenement::class)->find($id);
        $em->remove($event);
        $em->flush();
        $jsonContent=$normalizer->normalize($event,'json',['groups'=>'post:read']);
        return new Response("Deleted successfully".json_encode($jsonContent));
    }
    /**
     * @Route("/editApi/{id}", name="evenement_edit_api")
     */
    public function editjson(Request $request, $id,NormalizerInterface $normalizer)
    {
       $em=$this->getDoctrine()->getManager();
       $e=$em->getRepository(Evenement::class)->find($id);
       $e->setNameEvent($request->get('NameEvent'));
       $e->setPlaceEvent($request->get('PlaceEvent'));
       $e->setPriceEvent($request->get('PriceEvent'));
       $e->setNbParticipants($request->get('NbParticipants'));
       $e->setDateDebut(new \DateTime($request->get('DateDebut')));
       $e->setDateFin(new \DateTime($request->get('DateFin')));
       $em->flush();
        $jsonContent=$normalizer->normalize($e,'json',['groups'=>'post:read']);
        return new Response("update successfully".json_encode($jsonContent));


    }
    /**
     * @Route("/showApi/{id}", name="evenement_show_api")
     */
    public function showjson(Request $request,$id,NormalizerInterface $normalizer){
    $em=$this->getDoctrine()->getManager();
    $event=$em->getRepository(Evenement::class)->find($id);
        $jsonContent=$normalizer->normalize($event,'json',['groups'=>'post:read']);
        return new Response(json_encode($jsonContent));

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

            $entityManager->persist($evenement);
            $entityManager->flush();
            return $this->redirectToRoute('evenement_index');
        }

        return $this->render('evenement/new.html.twig', [
            'evenement' => $evenement,
            'form' => $form->createView(),
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
        if ($form->isSubmitted() ) {
            $entityManager->flush();

            return $this->redirectToRoute('evenement_index');
        }
        return $this->render('evenement/edit.html.twig', [
            'evenement' => $evenement,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/front", name="evenement_index2", methods={"GET"})
     */
    public function front(PaginatorInterface $paginator,Request $request)
    {
        $event=$this->getDoctrine()->getRepository(Evenement::class)->findAll();

        $evenements=$paginator->paginate($event,$request->query->getInt('page',1),3);
        return $this->render('evenement/indexfront.html.twig', [
            'evenements' => $evenements,
        ]);
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
        $logo = file_get_contents("logo.png");
        $logobase64 = base64_encode($logo);
        $evenements=$evenementRepository->findAll();

        $html=$this->renderView('evenement/printevent.html.twig', [
            'evenements' => $evenements,
            'logobase64'=>$logobase64,
        ]);
       $dompdf->loadHtml($html);
       $dompdf->setPaper('A4','portrait');
       $dompdf->render();
       $dompdf->stream('Events list.pdf',["Attachement" => false]);

    }
    /**
     * @IsGranted("ROLE_EVENT")
     * @Route("/calendar", name="calendar", methods={"GET"})
     */
    public function calendar(EvenementRepository $evenementRepository){

        $evs=$evenementRepository->findAll();
        $rdvs= [];
        foreach ($evs as $ev){
            $rdvs[]=[
                'id'=>$ev->getId(),
                'title'=>$ev->getNameEvent(),
                'description'=> $ev->getPlaceEvent(),
                'start'=>$ev->getDateDebut()->format('Y-m-d H:i:s'),
                'end'=>$ev->getDateFin()->format('Y-m-d H:i:s'),
                'backgroundColor'=>'#FF7474',
                'borderColor'=>'#000000',
                'textColor'=>'#000000',
                'editable'=>true,
            ];

        }
        //dd($rdvs);
        $data=json_encode($rdvs);
        //dd($data);
        return $this->render('evenement/calendar.html.twig',compact('data'));
    }


    /**
     * @IsGranted("ROLE_EVENT")
     * @Route("/api/{id}/edit", name="api_calendar_maj", methods={"PUT"})
     */
    public function majEvent(?Evenement $evenement,Request $request){
        $donnees=json_encode($request->getContent());
        if(
            isset($donnees->title)&& !empty($donnees->title) &&
            isset($donnees->description)&& !empty($donnees->description) &&
            isset($donnees->start)&& !empty($donnees->start) &&
            isset($donnees->end)&& !empty($donnees->end)

        ){
            $code=200;
            if(!$evenement){
                $evenement=new Evenement;
                $code=201;
            }

            $evenement->setDateDebut(new \DateTime($donnees->start));
            $evenement->setDateFin(new \DateTime($donnees->end));

            $em=$this->getDoctrine()->getManager();
            $em->persist($evenement);
            $em->flush();

            return new Response('ok',$code);

        }
        else{
            return new Response('Missing information',404);
        }
    }
    /**
     * @Route("/map",name="street")
     */
    public function mapAction(): Response
    {
        return $this->render('evenement/newMap.html.twig');
    }


    /**
     * @IsGranted("ROLE_PLAYER")
     * @Route("/front/{id}", name="evenement_show_front", methods={"GET"})
     */
    public function showfront(Evenement $evenement,$id,QrcodeService $qrcodeService): Response
    {
        //data
        $evenement=$this->getDoctrine()->getRepository(Evenement::class)->findOneBy(['id'=>$id]);
        $qrCode=$qrcodeService->qrcode($evenement->getNameEvent());
        //dd($qrCode);
        return $this->render('evenement/showfront.html.twig', [
            'evenement' => $evenement,
            'qrcode' =>$qrCode,
        ]);
    }





    /**
     * @IsGranted("ROLE_EVENT")
     * @Route("/{id}", name="evenement_show", methods={"GET"})
     */
    public function show(Evenement $evenement): Response
    {
        return $this->render('evenement/show.html.twig', [
            'evenement' => $evenement,
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