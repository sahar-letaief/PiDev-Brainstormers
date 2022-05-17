<?php

namespace App\Controller;

use App\Entity\Communication;
use App\Form\CommunicationType;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Routing\Annotation\Route;

use Sensio\Bundle\FrameworkExtraBundle\Configuration\IsGranted;

class CommunicationController extends AbstractController
{
    /**
     * @IsGranted("ROLE_ADMIN")
     * @Route("/communication", name="communication")
     */
    public function index(): Response
    {
        return $this->render('communication/index.html.twig', [
            'controller_name' => 'CommunicationController',
        ]);
    }
    /**
     * @IsGranted("ROLE_ADMIN")
     * @Route("/send", name="send")
     */
    public function send(Request $request): Response
    {
        $communication = new Communication();
        $form = $this->createForm(CommunicationType::class, $communication);

        $form->handleRequest($request);

        if($form->isSubmitted() && $form->isValid()){
            $communication->setSender($this->getUser());

            $em = $this->getDoctrine()->getManager();
            $em->persist($communication);
            $em->flush();

            $this->addFlash("message", "Message envoyé avec succès.");
            return $this->redirectToRoute("communication");
        }

        return $this->render("communication/send.html.twig", [
            "form" => $form->createView()
        ]);
    }
    /**
     * @IsGranted("ROLE_ADMIN")
     * @Route("/received", name="received")
     */
    public function received(): Response
    {
        return $this->render('communication/received.html.twig');
    }


    /**
     * @IsGranted("ROLE_ADMIN")
     * @Route("/sent", name="sent")
     */
    public function sent(): Response
    {
        return $this->render('communication/sent.html.twig');
    }

    /**
     * @IsGranted("ROLE_ADMIN")
     * @Route("/read/{id}", name="read")
     */
    public function read(Communication $message): Response
    {
        $message->setIsRead(true);
        $em = $this->getDoctrine()->getManager();
        $em->persist($message);
        $em->flush();

        return $this->render('communication/read.html.twig', compact("message"));
    }

    /**
     * @IsGranted("ROLE_ADMIN")
     * @Route("/drop/{id}", name="drop")
     */
   public function dropCommunication (Communication $message): Response
    {
        $em = $this->getDoctrine()->getManager();
        $em->remove($message);
        $em->flush();

        return $this->redirectToRoute("received");
    }


    //front
    /**
     * @IsGranted("ROLE_USER")
     * @Route("/communication_front", name="communication_front")
     */
    public function indexFront(): Response
    {
        return $this->render('communication/indexFront.html.twig', [
            'controller_name_front' => 'CommunicationControllerfront',
        ]);
    }
    /**
     * @IsGranted("ROLE_USER")
     * @Route("/send_front", name="send_front")
     */
    public function sendFront(Request $request): Response
    {
        $communication = new Communication();
        $form = $this->createForm(CommunicationType::class, $communication);

        $form->handleRequest($request);

        if($form->isSubmitted() && $form->isValid()){
            $communication->setSender($this->getUser());

            $em = $this->getDoctrine()->getManager();
            $em->persist($communication);
            $em->flush();

            $this->addFlash("message", "Message envoyé avec succès.");
            return $this->redirectToRoute("communication_front");
        }

        return $this->render("communication/sendFront.html.twig", [
            "form" => $form->createView()
        ]);
    }
    /**
     * @IsGranted("ROLE_USER")
     * @Route("/received_front", name="received_front")
     */
    public function receivedFront(): Response
    {
        return $this->render('communication/receivedFront.html.twig');
    }


    /**
     * @IsGranted("ROLE_USER")
     * @Route("/sent_front", name="sent_front")
     */
    public function sentFront(): Response
    {
        return $this->render('communication/sentFront.html.twig');
    }

    /**
     * @IsGranted("ROLE_USER")
     * @Route("/read_front/{id}", name="read_front")
     */
    public function readFront(Communication $message): Response
    {
        $message->setIsRead(true);
        $em = $this->getDoctrine()->getManager();
        $em->persist($message);
        $em->flush();

        return $this->render('communication/readFront.html.twig', compact("message"));
    }

    /**
     * @IsGranted("ROLE_USER")
     * @Route("/drop_front/{id}", name="drop_front")
     */
    public function dropCommunicationFront (Communication $message): Response
    {
        $em = $this->getDoctrine()->getManager();
        $em->remove($message);
        $em->flush();

        return $this->redirectToRoute("received_front");
    }

}
