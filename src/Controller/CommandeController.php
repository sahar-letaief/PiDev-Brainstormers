<?php

namespace App\Controller;

use App\Entity\Commande;
use App\Form\CommandeType;
use App\Repository\CommandeRepository;
use App\Repository\ProductRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\HttpFoundation\Session\SessionInterface;


/**
 * @Route("/commande")
 */
class CommandeController extends AbstractController
{
    /**
     * @Route("/", name="commande_index", methods={"GET"})
     */
    public function index(CommandeRepository $commandeRepository, ProductRepository $productRepository): Response
    {
        
        return $this->render('commande/index.html.twig', [
            'commandes' => $commandeRepository->findAll(),
            'products' => $productRepository->findAll(),
        ]);
        
    }

/**
     * @Route("/commandeBack", name="commande_Back", methods={"GET"})
     */
    public function index_Back(CommandeRepository $commandeRepository, ProductRepository $productRepository): Response
    {
        
        return $this->render('commande/indexback.html.twig', [
            'commandes' => $commandeRepository->findAll(),
            'products' => $productRepository->findAll(),
        ]);
        
    }

    /**
     * @Route("/new", name="commande_new", methods={"GET", "POST"})
     */

    public function new(Request $request,ProductRepository $ProductRepository,SessionInterface $session, EntityManagerInterface $entityManager): Response
    {   
        // user id
        //$userId = $user->getId();
        $userId = 1;
        //dd($userId); 
        $pannier = $session->get('pannier', []);
        $pannierxithData = [];  
        $commande = new Commande();
        $form = $this->createForm(CommandeType::class, $commande);
        $form->handleRequest($request);
        $a=array();
        foreach ($pannier as $id => $quantity) {
            $pannierxithData[] = [
                'product' => $ProductRepository->find($id),
                'quantity' => $quantity,
            ];
        }
        for ($x = 0; $x<=count($pannierxithData)-1; $x++) {
             $a[$x]['quantity'] = $pannierxithData[$x]['quantity'];           
             $a[$x]['ProductName'] = $pannierxithData[$x]['product']->getName();
             $a[$x]['quantity'] = $pannierxithData[$x]['quantity'];           
             $a[$x]['ProductName'] = $pannierxithData[$x]['product']->getName();
            }
            //dd($a);
        
        if ($form->isSubmitted() && $form->isValid()) {
            $commande->setProd($a);
            // $commande->setUser($userId);
              

            $entityManager->persist($commande);            
            $entityManager->flush();

            return $this->redirectToRoute('commande_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('commande/new.html.twig', [
            'commande' => $commande,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="commande_show", methods={"GET"})
     */
    public function show(Commande $commande ,ProductRepository $ProductRepository): Response
    {
        return $this->render('commande/show.html.twig', [
            'commande' => $commande,
            'products' => $ProductRepository->findAll(),
        ]);
    }

    /**
     * @Route("/{id}", name="commande_show_back", methods={"GET"})
     */
    public function showback(Commande $commande ,ProductRepository $ProductRepository): Response
    {
        return $this->render('commande/showback.html.twig', [
            'commande' => $commande,
            'products' => $ProductRepository->findAll(),
        ]);
    }


    /**
     * @Route("/{id}/edit", name="commande_edit", methods={"GET", "POST"})
     */
    public function edit(Request $request, Commande $commande, EntityManagerInterface $entityManager): Response
    {
        $form = $this->createForm(CommandeType::class, $commande);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->flush();

            return $this->redirectToRoute('commande_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('commande/edit.html.twig', [
            'commande' => $commande,
            'form' => $form->createView(),
        ]);
    }



     /**
     * @Route("/{id}/edit", name="commande_edit_back", methods={"GET", "POST"})
     */
    public function editback(Request $request, Commande $commande, EntityManagerInterface $entityManager): Response
    {
        $form = $this->createForm(CommandeType::class, $commande);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->flush();

            return $this->redirectToRoute('commande_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('commande/editback.html.twig', [
            'commande' => $commande,
            'form' => $form->createView(),
        ]);
    }



    /**
     * @Route("/{id}", name="commande_delete", methods={"POST"})
     */
    public function delete(Request $request, Commande $commande, EntityManagerInterface $entityManager): Response
    {
        if ($this->isCsrfTokenValid('delete'.$commande->getId(), $request->request->get('_token'))) {
            $entityManager->remove($commande);
            $entityManager->flush();
        }

        return $this->redirectToRoute('commande_index', [], Response::HTTP_SEE_OTHER);
    }
}
