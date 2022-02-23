<?php

namespace App\Controller;

use App\Entity\Reclamation;
use App\Form\ReclamationType;
use App\Repository\ReclamationRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\RedirectResponse;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;


class ReclamationController extends AbstractController
{
    /**
     * @Route("/home", name="home")
     */
    public function home (): Response
    {
        return $this->render('baseBack.html.twig', [
        ]);
    }
//back
    /**
     * @Route("/liste", name="reclamation_index", methods={"GET"})
     */
    public function index(ReclamationRepository $reclamationRepository): Response
    {
        return $this->render('reclamation/show.html.twig', [
            'reclamations' => $reclamationRepository->findAll(),
        ]);
    }
// front
    /**
     * @Route("/frontlist", name="frontlist", methods={"GET"})
     */
    public function listFrontReclamations (ReclamationRepository $reclamationRepository): Response
    {

        return $this->render('reclamation/list.html.twig', [
            'reclamation' => $reclamationRepository->findAll(),
        ]);
    }
    /**
     * @Route("/new", name="reclamation_new", methods={"GET", "POST"})
     */
    public function addReclamation (Request $request, EntityManagerInterface $entityManager): Response
    {
        $reclamation = new Reclamation();
        $reclamation->setCreateResolution(new \DateTime(('2000-04-13T20:00:00')));

        //$reclamation->setCreateResolution("");
        $form = $this->createForm(ReclamationType::class, $reclamation);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {

            $entityManager->persist($reclamation);
            $entityManager->flush();

            return $this->redirectToRoute('frontlist', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('reclamation/addReclamation.html.twig', [
            'reclamation' => $reclamation,
            'form' => $form->createView(),
        ]);
    }
    /**
     * @Route("/{id}/edit", name="reclamation_edit", methods={"GET", "POST"})
     */
    public function updateReclamation(Request $request, Reclamation $reclamation, EntityManagerInterface $entityManager): Response
    {

        $form = $this->createForm(ReclamationType::class, $reclamation);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->flush();

            return $this->redirectToRoute('reclamation_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('reclamation/edit.html.twig', [
            'reclamation' => $reclamation,
            'form' => $form->createView(),
        ]);


    }
    /**
     * @Route("/delete/{id}", name="reclamation_delete", methods={"GET","POST"})
     */
    public function delete(ReclamationRepository $set,$id): Response
    {
        //dd("rihab");
        $reclamation = $set->find($id);
       // $reclamation=$this->getDoctrine()->getRepository(reclamation::class)->find($id);
        $em=$this->getDoctrine()->getManager();
        $em->remove($reclamation);
        $em->flush();
        return $this-> redirectToRoute('frontlist');
    }


    /**
     * @Route("/acceptstatus/{id}", name="accept_status", methods={"GET","POST"})
     */
    public function AccepterStatus(ReclamationRepository $set,$id): Response
    {
        //dd("rihab");
        $reclamation = $set->find($id);
        // $reclamation=$this->getDoctrine()->getRepository(reclamation::class)->find($id);
        $reclamation->setStatus("accept");
        $reclamation->setCreateResolution(new \DateTime());

        $em=$this->getDoctrine()->getManager();
        $em->flush();
        return $this-> redirectToRoute('reclamation_index');
    }
    /**
     * @Route("/refusstatus/{id}", name="refus_status", methods={"GET","POST"})
     */
    public function RefuserStatus(ReclamationRepository $set,$id): Response
    {
        //dd("rihab");
        $reclamation = $set->find($id);
        // $reclamation=$this->getDoctrine()->getRepository(reclamation::class)->find($id);
        $reclamation->setStatus("refus");
        $reclamation->setCreateResolution(new \DateTime());
        $em=$this->getDoctrine()->getManager();
        $em->flush();
        return $this-> redirectToRoute('reclamation_index');
    }

}
