<?php

namespace App\Controller;

use App\Entity\Commande;
use App\Entity\CommandeSearch;
use App\Form\CommandeType;
use App\Form\CommandeSearchType;
use Symfony\Component\Form\Extension\Core\Type\SearchType;
use App\Repository\CommandeRepository;
use App\Repository\ProductRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\HttpFoundation\Session\SessionInterface;
use Dompdf\Dompdf;
use Dompdf\Options;
use Knp\Component\Pager\PaginatorInterface;
use Symfony\Component\Serializer\Normalizer\NormalizerInterface;



/**
 * @Route("/commande")
 */
class CommandeController extends AbstractController
{
    /**
     * @Route("/", name="commande_index", methods={"GET","POST"})
     */
    public function index(Request $request, CommandeRepository $commandeRepository, ProductRepository $productRepository , PaginatorInterface $paginator): Response
    {   

       // $commande = new Commande();
        $form = $this->createForm(CommandeSearchType::class);
        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid())
           {
                $term = $form['ref_cmde']->getData();
                
                $allcommande= $commandeRepository->search($term);
            }
            else
            {
               $allcommande= $commandeRepository->findAll(); 
            }
        $commandes=$paginator->paginate($allcommande,$request->query->getInt('page',1),2);
        return $this->render('commande/index.html.twig',[
            'commandes' => $commandes,
            'products' => $productRepository->findAll(),
            'form' => $form->createView()
            ]);    
    }

        /**
         * Search action.
         * @Route("/search/", name="search")
         * @param  Request               $request Request instance
         * @param  string                $search  Search term
         * @return Response|JsonResponse          Response instance
         */
        //public function searchAction(Request $request)
        //{
            //if (!$request->isXmlHttpRequest()) {
                //return $this->render("search.html.twig");
            //}

            //if (!$searchTerm = trim($request->query->get("search", $search))) {
                //return new JsonResponse(["error" => "Search term not specified."], Response::HTTP_BAD_REQUEST);
            //}

            //$em = $this->getDoctrine()->getManager();
            //if (!($results = $em->getRepository(User::class)->findOneByEmail($searchTerm))) {
                //return new JsonResponse(["error" => "No results found."], Response::HTTP_NOT_FOUND);
            //}

            //return new JsonResponse([
              //  "html" => $this->renderView("search.ajax.twig", ["results" => $results]),
            //]);
        //}


     /**
     * @Route("/{id}/list", name="commande_liste", methods={"GET"})
     */
    public function list(Commande $commande,CommandeRepository $commandeRepository, ProductRepository $productRepository): Response
    {
        // Configure Dompdf according to your needs
        $pdfOptions = new Options();
        $pdfOptions->set('defaultFont', 'Arial');
        
        // Instantiate Dompdf with our options
        $dompdf = new Dompdf($pdfOptions);
        

        // Retrieve the HTML generated in our twig file
        $html = $this->renderView('commande/liste.html.twig', [
            'commande' => $commande,
            'products' => $productRepository->findAll(),
        ]);
        
        // Load HTML to Dompdf
        $dompdf->loadHtml($html);
        
        // (Optional) Setup the paper size and orientation 'portrait' or 'portrait'
        $dompdf->setPaper('A4', 'portrait');

        // Render the HTML as PDF
        $dompdf->render();

        // Output the generated PDF to Browser (force download)
        $dompdf->stream("mypdf.pdf", [
            "Attachment" => true
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



    //json
    /**
     * @Route("/Commande/{id}", name="Commande/{id}")
     */
    public function Comandeid(Request $request,$id,NormalizerInterface $Normalizer )
        {
    //Nous utilisons la Repository pour récupérer les objets que nous avons dans la base de données
    $em=$this->getDoctrine()->getManager();
    $commandes =$em->getRepository(Commande::class)->find($id);
    
    //Nous utilisons la fonction normalize qui transforme en format JSON nos donnée qui sont
    //en tableau d'objet Students
    $jsonContent=$Normalizer->normalize($commandes,'json',['groups'=>'post:read']);
    
 
    return new Response(json_encode($jsonContent));

    }
    /**
     * @Route("/AddCommande/new", name="AddCommande")
     */

    public function new_cmde(Request $request,ProductRepository $ProductRepository,SessionInterface $session, EntityManagerInterface $entityManager): Response
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
         $jsonContent=$Normalizer->normalize($commandes,'json',['groups'=>'post:read']);
    
 
        return new Response(json_encode($jsonContent));
    }

/**
     * @Route("/AllComande", name="AllComande")
     */
    public function AllComande(NormalizerInterface $Normalizer )
    {
    //Nous utilisons la Repository pour récupérer les objets que nous avons dans la base de données
    $repository =$this->getDoctrine()->getRepository(Commande::class);
    $comandes=$repository->FindAll();
    //Nous utilisons la fonction normalize qui transforme en format JSON nos donnée qui sont
    //en tableau d'objet Students
    $jsonContent=$Normalizer->normalize($comandes,'json',['groups'=>'post:read']);
    
    
    
    return new Response(json_encode($jsonContent));
    dump($jsonContent);
    die;
}
    







}
