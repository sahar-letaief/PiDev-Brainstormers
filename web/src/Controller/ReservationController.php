<?php

namespace App\Controller;

use App\Entity\Evenement;
use App\Entity\Reservation;
use App\Entity\User;
use App\Form\ReservationType;
use App\Repository\EvenementRepository;
use App\Repository\ReservationRepository;
use App\Repository\UserRepository;
use Doctrine\ORM\EntityManagerInterface;
use Knp\Component\Pager\Pagination\PaginationInterface;
use Knp\Component\Pager\PaginatorInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\IsGranted;
use Symfony\Component\Serializer\Normalizer\NormalizerInterface;



/**
 * @Route("/reservation")
 */
class ReservationController extends AbstractController
{


    /**
     * @IsGranted("ROLE_EVENT")
     * @Route("/", name="reservation_index",methods={"GET","POST"})
     */
    public function index(ReservationRepository $reservationRepository,Request $request,PaginatorInterface $paginator): Response
    {
        $data=$this->getDoctrine()->getRepository(Reservation::class)->findAll();
        $user=$this->getUser();
       // $reservations=$reservationRepository->findAll();
        $reservations=$paginator->paginate($data,$request->query->getInt('page',1),3);
        $back = null;
        if($request->isMethod("POST")) {
            $type = $request->request->get('optionsearch');
            $value = $request->request->get('Search');
            switch ($type) {
                case 'NameEvent':
                    $res = $reservationRepository->findByNameEvent($value);
                    break;

                case 'firstname':
                    $res = $reservationRepository->findByFirstName($value);
                    break;

                case 'lastname':
                    $res = $reservationRepository->findByLastName($value);
                    break;

                case 'email':
                    $res = $reservationRepository->findByEmail($value);
                    break;
            }

            if ($res) {
                $back = "success";
            } else {
                $back = "failure";
            }
            $reservations = $paginator->paginate($data, $request->query->getInt('page', 1), 3);
            return $this->render('reservation/indexback.html.twig', array('reservations'=>$reservations,'user'=>$user,'back' => $back));
        }

        return $this->render('reservation/indexback.html.twig', array('reservations'=>$reservations,'user'=>$user,'back' => $back));

    }
    /**
     * @Route("/apiDisplay/{idu}", name="reservation_index2_api2")
     */
    public function indexfrontjsonfront(ReservationRepository $reservationRepository,Request $request,NormalizerInterface $Normalizer,$idu)
    {
        $user=$this->getUser();
        $user=$this->getDoctrine()->getRepository(User::class)->findOneBy(['id'=>$idu]);
        $reservations=$this->getDoctrine()->getRepository(Reservation::class)->findby(['user'=>$user]);
        //dd($reservations);
        $jsonContent=$Normalizer->normalize($reservations,'json',['groups'=>'post:read']);
       // dd($jsonContent);
        return new Response(json_encode($jsonContent));

    }
    /**
     * @Route("/apiDisplay", name="reservation_index2_api")
     */
    public function indexfrontjson(ReservationRepository $reservationRepository,Request $request,NormalizerInterface $Normalizer)
    {
        $user=$this->getUser();

        $reservations=$this->getDoctrine()->getRepository(Reservation::class)->findAll();
       //dd($reservations);
        $jsonContent=$Normalizer->normalize($reservations,'json',['groups'=>'post:read']);
        //dd($jsonContent);
       return new Response(json_encode($jsonContent));

    }
    /**
     * @IsGranted("ROLE_PLAYER")
     * @Route("/front", name="reservation_index2", methods={"GET"})
     */
    public function indexfront(ReservationRepository $reservationRepository,Request $request)
    {
        $user=$this->getUser();
        $IdUser=$user->getId();
        //dd($IdUser);
       // $reservations=$this->getDoctrine()->getRepository(Reservation::class)->findOneBy(['id'=>$user->getId()]);
        //dd($user);
        //dd($reservations);
        $reservation = new Reservation();

        $reservations=$this->getDoctrine()->getRepository(Reservation::class)->findBy(['user'=>$IdUser]);
        //dd($reservations);
        $reservation->setDateReservation(new \DateTime('now'));

        return $this->render('reservation/indexfront.html.twig', [
            'reservations' => $reservations,
            'user'=>$user,
        ]);
    }


    /**
     * @IsGranted("ROLE_PLAYER")
     * @Route("/new/{id}", name="reservation_new_front", methods={"GET", "POST"})
    */
    public function new_front(Request $request, EntityManagerInterface $entityManager,$id): Response
    {
        $DateReservation = date('d-m-y , h:m');
        $user=$this->getUser();
        $evenement=$this->getDoctrine()->getRepository(Evenement::class)->findOneBy(['id'=>$id]);
        $evenement->setNbParticipants($evenement->getNbParticipants()-1);
        $NameEvent=$evenement->getNameEvent();
        $reservation = new Reservation();
        $reservation->setDateReservation(new \DateTime('now'));
        $ev=$evenement->setNameEvent($NameEvent);
        $reservation->setEvenement($ev);
        $DateReservation=$reservation->getDateReservation();
        $reservation->setUser($user);
        $form = $this->createForm(ReservationType::class, $reservation);
        $form->handleRequest($request);
        if ($form->isSubmitted() ) {
            $entityManager->persist($reservation);
            $entityManager->flush();
            $this->get('session')->getFlashBag()->add('notice','Reservation added successfully');
            return $this->redirectToRoute('evenement_index2', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('reservation/new.html.twig', [
            'reservation' => $reservation,
            'user' => $user,
            'evenement' =>$evenement,
            'ev'=> $ev,
            'NameEvent'=>$NameEvent,
            'DateReservation'=>$DateReservation,
            'form' => $form->createView(),
        ]);
    }
    /**
     * @Route("/new/api/{id}/{idu}", name="reservation_new_front_api")
     */
    public function new_frontjson(Request $request, EntityManagerInterface $entityManager,NormalizerInterface $Normalizer,$id,$idu): Response
    {
        $DateReservation = date('d-m-y , h:m');
       // $user=$this->getUser();
        $user=$this->getDoctrine()->getRepository(User::class)->findOneBy(['id'=>$idu]);
        $evenement=$this->getDoctrine()->getRepository(Evenement::class)->findOneBy(['id'=>$id]);
        $evenement->setNbParticipants($evenement->getNbParticipants()-1);
        $NameEvent=$evenement->getNameEvent();
        $reservation = new Reservation();
        $reservation->setDateReservation(new \DateTime('now'));
        $ev=$evenement->setNameEvent($NameEvent);
        $reservation->setEvenement($ev);
        $DateReservation=$reservation->getDateReservation();
        $reservation->setUser($user);
        //dd($reservation);
        $entityManager->persist($reservation);
        $entityManager->flush();
        $jsonContent=$Normalizer->normalize($reservation,'json',['groups'=>'post:read']);
        //dd($jsonContent);
        return new Response("reservation added successfully".json_encode($jsonContent));
    }




    /**
     * @IsGranted("ROLE_PLAYER")
     * @Route("/{id}", name="reservation_show", methods={"GET"})
     */
    public function show(Reservation $reservation): Response
    {
        $user=$this->getUser();

        return $this->render('reservation/show.html.twig', [
            'reservation' => $reservation,
            'user'=>$user,
        ]);
    }




    /**
     * @IsGranted("ROLE_PLAYER")
     * @Route("/delete/{id}", name="reservation_delete")
     */
    public function delete(ReservationRepository $repo,$id)
    {
        $res=$repo->find($id);
        $em=$this->getDoctrine()->getManager();
        $em->remove($res);
        $em->flush();

        return $this->redirectToRoute('reservation_index', [], Response::HTTP_SEE_OTHER);
    }

    /**
     * @Route("/deleteApi/{idR}", name="reservation_delete_api")
     */
    public function deletejson(ReservationRepository $repo,$idR,NormalizerInterface $Normalizer)
    {
        $res = $repo->find($idR);
        $res->getEvenement()->setNbParticipants($res->getEvenement()->getNbParticipants()+1);
        $em = $this->getDoctrine()->getManager();
        $em->remove($res);
        $em->flush();
        $jsonContent=$Normalizer->normalize($em,'json',['groups'=>'post:read']);
        return new Response("reservation deleted successfully".json_encode($jsonContent));


    }
    /**
     * @IsGranted("ROLE_PLAYER")
     * @Route("/font/delete/{idR}", name="reservation_delete_front")
     */
    public function deletefront(ReservationRepository $repo,$idR)
    {
        $res = $repo->find($idR);
        $res->getEvenement()->setNbParticipants($res->getEvenement()->getNbParticipants()+1);

        //dd($res->getEvenement()->getId());
        //$IdEvent=$res->getEvenement()->getId();
        $em = $this->getDoctrine()->getManager();
        $em->remove($res);
        $em->flush();

        return $this->redirectToRoute('reservation_index2', [], Response::HTTP_SEE_OTHER);
    }

}