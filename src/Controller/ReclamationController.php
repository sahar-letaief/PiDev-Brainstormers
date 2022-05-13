<?php

namespace App\Controller;

use App\Entity\Reclamation;
use App\Form\ReclamationType;
use App\Form\ReclamationSearchType;
use App\Repository\ReclamationRepository;
use App\Repository\UserRepository;
use Doctrine\ORM\EntityManagerInterface;
use SebastianBergmann\Template\Template;
use Symfony\Bridge\Twig\Mime\TemplatedEmail;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\RedirectResponse;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Captcha\Bundle\CaptchaBundle\CaptchaBundle;
use Symfony\Component\Mailer\MailerInterface;
use Symfony\Component\Mime\Email;
use Symfony\Component\Routing\Annotation\Route;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\IsGranted;
use Knp\Component\Pager\PaginatorInterface;


class ReclamationController extends AbstractController
{
//back
    /**

     * @Route("/home", name="home")
     */
   /* public function home (): Response
    {
        return $this->render('baseBack.html.twig', [
        ]);
    }*/

    /**
     * @IsGranted("ROLE_ADMIN")
     * @Route("/liste", name="reclamation_index", methods={"GET","POST"})
     */
    public function index(Request $request,ReclamationRepository $reclamationRepository, PaginatorInterface $paginator): Response
    {
        $form = $this->createForm(ReclamationSearchType::class);
        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid())
        {
           // $term = $form['Title']->getData();
         //   $reclamation = $reclamationRepository->search($term);

            $term = $form['Title']->getData();

            $description = $form['Description']->getData();
            $reclamation= $reclamationRepository->search($term,$description);
        }
        else
        {
            $reclamation= $reclamationRepository->findAll();
        }

        $reclamations = $paginator->paginate($reclamation,$request->query->getInt('page', 1),5);

        return $this->render('reclamation/show.html.twig', [
            'reclamations' => $reclamations,
            'form' => $form->createView()
        ]);



    }
// front
    /**
     * @IsGranted("ROLE_RECLAMATION")
     * @Route("/frontlist", name="frontlist", methods={"GET"})
     */
    public function listFrontReclamations (ReclamationRepository $reclamationRepository): Response
    {

        return $this->render('reclamation/list.html.twig', [
            'reclamation' => $reclamationRepository->findAll(),
        ]);
    }
    /**
     * @IsGranted("ROLE_RECLAMATION")
     * @Route("/new", name="reclamation_new", methods={"GET", "POST"})
     */
    public function addReclamation (Request $request, EntityManagerInterface $entityManager,MailerInterface  $mailer): Response
    {
        $reclamation = new Reclamation();
        $reclamation->setCreateResolution(new \DateTime(('2000-04-13T20:00:00')));

        //$reclamation->setCreateResolution("");
        $form = $this->createForm(ReclamationType::class, $reclamation);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->persist($reclamation);
            $entityManager->flush();
            $message=(new TemplatedEmail())
                ->from('gamexproject7@gmail.com')
                ->to('rihab.aljene@esprit.tn')
                ->subject('new reclamation added')
                ->text($reclamation->getDescription())
                ->htmlTemplate('reclamation/email/email.html.twig');


            $mailer->send($message);
            return $this->redirectToRoute('frontlist', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('reclamation/addReclamation.html.twig', [
            'reclamation' => $reclamation,
            'form' => $form->createView(),
        ]);
    }
    /**
     * @IsGranted("ROLE_RECLAMATION")
     * @Route("/{id}/edit", name="reclamation_edit", methods={"GET", "POST"})
     */
    public function updateReclamation(Request $request, Reclamation $reclamation, EntityManagerInterface $entityManager): Response
    {

        $form = $this->createForm(ReclamationType::class, $reclamation);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->flush();

            return $this->redirectToRoute('frontlist', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('reclamation/edit.html.twig', [
            'reclamation' => $reclamation,
            'form' => $form->createView(),
        ]);


    }
    /**
     * @IsGranted("ROLE_RECLAMATION")
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
     * @IsGranted("ROLE_ADMIN")
     * @Route("/acceptstatus/{id}", name="accept_status", methods={"GET","POST"})
     */
    public function AccepterStatus(ReclamationRepository $set,$id): Response
    {
        //dd("rihab");
        $reclamation = $set->find($id);
        $reclamation->setStatus("accept");
        $reclamation->setCreateResolution(new \DateTime());

        $em=$this->getDoctrine()->getManager();
        $em->flush();
        return $this-> redirectToRoute('reclamation_index');
    }
    /**
     * @IsGranted("ROLE_ADMIN")
     * @Route("/refusstatus/{id}", name="refus_status", methods={"GET","POST"})
     */
    public function RefuserStatus(ReclamationRepository $set,$id): Response
    {
        //dd("rihab");
        $reclamation = $set->find($id);
        $reclamation->setStatus("refus");
        $reclamation->setCreateResolution(new \DateTime());
        $em=$this->getDoctrine()->getManager();
        $em->flush();
        return $this-> redirectToRoute('reclamation_index');
    }

 //   public function adminMail(UserRepository $users)
  //  {
      //  $ = $users->find($);


   // }
}
