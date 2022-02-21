<?php

namespace App\Controller;

use App\Entity\Evenement;
use App\Entity\Reservation;
use App\Form\ReservationType;
use App\Repository\ReservationRepository;
use Doctrine\ORM\EntityManagerInterface;
use Knp\Component\Pager\Pagination\PaginationInterface;
use Knp\Component\Pager\PaginatorInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/reservation")
 */
class ReservationController extends AbstractController
{
    /**
     * @Route("/", name="reservation_index", methods={"GET"})
     */
    public function index(ReservationRepository $reservationRepository,Request $request,PaginatorInterface $paginator): Response
    {
        $data=$this->getDoctrine()->getRepository(Reservation::class)->findAll();

       // $reservations=$reservationRepository->findAll();
        $reservations=$paginator->paginate($data,$request->query->getInt('page',1),2);

        return $this->render('Back/reservation/index.html.twig', [
            'reservations' => $reservations,
        ]);
    }
    /**
     * @Route("/new", name="reservation_new_front", methods={"GET", "POST"})

    public function new_front(Request $request, EntityManagerInterface $entityManager,UserRepository $UserRepository,$idR,EvenementRepository $evenementRepository,$idE): Response
    {
        $user= $UserRepository->findOneBy(['id',$idR]);
        $event=$evenementRepository->findOneBy(['id',$idE]);

        $reservation = new Reservation();
        $form = $this->createForm(ReservationType::class, $reservation);
        $form->handleRequest($request);

        if ($form->isSubmitted() ) {
            $entityManager->persist($reservation);
            $entityManager->flush();

            return $this->redirectToRoute('evenement_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('Front/reservation/new.html.twig', [
            'reservation' => $reservation,
            'user' => $user,
            'event' =>$event,
            'form' => $form->createView(),
        ]);
    }*/

    /**
     * @Route("/new", name="reservation_new", methods={"GET", "POST"})
     */
    public function new(Request $request, EntityManagerInterface $entityManager): Response
    {
        $reservation = new Reservation();
        $form = $this->createForm(ReservationType::class, $reservation);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->persist($reservation);
            $entityManager->flush();

            return $this->redirectToRoute('reservation_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('Back/reservation/new.html.twig', [
            'reservation' => $reservation,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="reservation_show", methods={"GET"})
     */
    public function show(Reservation $reservation): Response
    {
        return $this->render('Back/reservation/show.html.twig', [
            'reservation' => $reservation,
        ]);
    }

    /**
     * @Route("/{id}/edit", name="reservation_edit", methods={"GET", "POST"})
     */
    public function edit(Request $request, Reservation $reservation, EntityManagerInterface $entityManager): Response
    {
        $form = $this->createForm(ReservationType::class, $reservation);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->flush();

            return $this->redirectToRoute('reservation_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('Back/reservation/edit.html.twig', [
            'reservation' => $reservation,
            'form' => $form->createView(),
        ]);
    }

    /**
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
     * @Route("/front/add", name="reservation_add_front")
     */
    public function fetchFront(){  //UserRepository
        //recuperation user nekhedh id
        //$user=$this->getUser();/
        //return $this->render(Front/reservation/indexfront.html.twig,[
        //'user'=> $user]);
        //$event=$eventRepository->findby(id);
        //$event.NbParticipants=-1;


    }
}
