<?php

namespace App\Controller;

use App\Entity\Communication;
use App\Form\CommunicationType;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Routing\Annotation\Route;

class CommunicationController extends AbstractController
{
    /**
     * @Route("/communication", name="communication")
     */
    public function index(): Response
    {
        return $this->render('communication/index.html.twig', [
            'controller_name' => 'CommunicationController',
        ]);
    }
    /**
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
     * @Route("/received", name="received")
     */
    public function received(): Response
    {
        return $this->render('communication/received.html.twig');
    }


    /**
     * @Route("/sent", name="sent")
     */
    public function sent(): Response
    {
        return $this->render('communication/sent.html.twig');
    }

    /**
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
     * @Route("/delete/{id}", name="delete")
     */
    public function delete(Communication $message): Response
    {
        $em = $this->getDoctrine()->getManager();
        $em->remove($message);
        $em->flush();

        return $this->redirectToRoute("received");
    }

}
