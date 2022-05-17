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
use Sensio\Bundle\FrameworkExtraBundle\Configuration\IsGranted;



use Symfony\Component\Serializer\Normalizer\ObjectNormalizer;
use Symfony\Component\Serializer\Serializer;
use Symfony\Component\Serializer\Encoder\JsonEncoder;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Method;



/**
 * @Route("/commande")
 */
class CommandeController extends AbstractController
{

         /**
     * @Route("/AllComandes", name="AllComande")
     */
    
    public function AllComandes(NormalizerInterface $Normalizer )
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







    /**
     * @IsGranted("ROLE_USER")
     * @Route("/AllComande", name="commande_index", methods={"GET","POST"})
     */
    public function index(Request $request, CommandeRepository $commandeRepository, ProductRepository $productRepository , PaginatorInterface $paginator): Response
    {   

       // $commande = new Commande();
        $form = $this->createForm(CommandeSearchType::class);
        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid())
           {
                $term = $form['ref_cmde']->getData();
                //$description = $form['Pays']->getData();
                $allcommande= $commandeRepository->search($term);
            }
        else
            {
               $allcommande= $commandeRepository->commandeforuser($this->getUser()->getId()); 
               //dd($allcommande);
            }
        $commandes=$paginator->paginate($allcommande,$request->query->getInt('page',1),2);
        return $this->render('commande_Front/index.html.twig',[
            'commandes' => $commandes,
            'products' => $productRepository->findAll(),
            'form' => $form->createView()
            ]);    
    }

    
    /**
     * @Route("/AllComande", name="commande_indexu", methods={"GET"})
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

  /**
         * @Route("/Search", name="demo_create")
         * @return Response|JsonResponse 
         * 
        */
        public function index3(Request $request,CommandeRepository $commandeRepository,PaginatorInterface $paginator) : Response
        {
            // $tab=  ["éa ","d"];
            $emailValue = $request->get('search');
            //dd($emailValue);
            $allcommande= $commandeRepository->search($emailValue);
            $arr = (object) $allcommande;

            $commandes=$paginator->paginate($allcommande,$request->query->getInt('page',1),2);
            if($request->get('path')){
            return new JsonResponse([
                'content' => $this->renderView('commande_Front/contentajax.html.twig', ["commandes" => $commandes])
            ]);
        }
            return new JsonResponse([
               "html" => $this->renderView("commande_Front/index.html.twig", ["commandes" => $commandes]),
            ]);
            return Response::json($allcommande);
            // $response = new JsonResponse();
            // $response->setStatusCode(200);
            return $response->setData(['search' => $allcommande ]);

        }








        /**
     * @Route("/admin/utilisateur/search", name="utilsearch")
     */
    public function searchPlanajax(Request $request) 
    {
        $repository = $this->getDoctrine()->getRepository(Commande::class);
        $requestString = $request->get('searchValue');
        $plan = $repository->findPlanBySujet($requestString);
        return $this->render('commande_Front/utilajax.html.twig', [
            'commandes' => $plan,
        ]);
    }


     /**
      * @IsGranted("ROLE_USER")
     * @Route("/{id}/list", name="commande_liste", methods={"GET"})
     */
    public function list(Commande $commande,CommandeRepository $commandeRepository, ProductRepository $productRepository): Response
    {
        // Configure Dompdf according to your needs
        $pdfOptions = new Options();
        $pdfOptions->set('defaultFont', 'Arial');
        
        // Instantiate Dompdf with our options
        $dompdf = new Dompdf($pdfOptions);
        $png = file_get_contents("logo9.png");
        $png2 = file_get_contents("GameX.png");
        $pngbase64 = base64_encode($png);
        $pngbase643 = base64_encode($png2);

        // Retrieve the HTML generated in our twig file
        $html = $this->renderView('commande_Front/liste.html.twig', [
            'commande' => $commande,
            "img64"=>$pngbase64,
            "img643"=>$pngbase643,
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
 * @IsGranted("ROLE_ADMIN")
     * @Route("/commandeBack", name="commande_Back", methods={"GET","POST"})
     */
    public function index_Back(Request $request,CommandeRepository $commandeRepository, ProductRepository $productRepository ,PaginatorInterface $paginator): Response
    {
        $form = $this->createForm(CommandeSearchType::class);
        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid())
           {
                $term = $form['ref_cmde']->getData();
                //$description = $form['Pays']->getData();
                $allcommande= $commandeRepository->search($term);
            }
        else
            {
               $allcommande= $commandeRepository->findAll(); 
            }
        $commandes=$paginator->paginate($allcommande,$request->query->getInt('page',1),4);
        //dd($commandes);
        return $this->render('commande_Back/indexback.html.twig', [
            'commandes' => $commandes,
            'products' => $productRepository->findAll(),
            'form' => $form->createView()
        ]);
        
    }

    /**
     * @IsGranted("ROLE_USER")
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
             $a[$x]['ProductName'] = $pannierxithData[$x]['product']->getProductName();
             $a[$x]['ProductPrice'] = $pannierxithData[$x]['product']->getPrice();
            }
           
            //dd($a);
        
        if ($form->isSubmitted() && $form->isValid()) {
            $commande->setProd($a);
            $commande->setUser($this->getUser());
        
            $entityManager->persist($commande);            
            $entityManager->flush();

            return $this->redirectToRoute('commande_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('commande_Front/new.html.twig', [
            'commande' => $commande,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @IsGranted("ROLE_USER")
     * @Route("/{id}", name="commande_show", methods={"GET"})
     */
    public function show(Commande $commande ,ProductRepository $ProductRepository): Response
    {
        return $this->render('commande_Front/show.html.twig', [
            'commande' => $commande,
            'products' => $ProductRepository->findAll(),
        ]);
    }

    /**
     * @IsGranted("ROLE_ADMIN")
     * @Route("/{id}", name="commande_show_back", methods={"GET"})
     */
    public function showback(Commande $commande ,ProductRepository $ProductRepository): Response
    {
        return $this->render('commande_Back/showback.html.twig', [
            'commande' => $commande,
            'products' => $ProductRepository->findAll(),
        ]);
    }


    /**
     * @IsGranted("ROLE_USER")
     * @Route("/front/{id}/edit", name="commande_edit", methods={"GET", "POST"})
     */
    public function edit(Request $request, Commande $commande, EntityManagerInterface $entityManager): Response
    {
        $form = $this->createForm(CommandeType::class, $commande);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->flush();

            return $this->redirectToRoute('commande_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('commande_Front/edit.html.twig', [
            'commande' => $commande,
            'form' => $form->createView(),
        ]);
    }



     /**
      * @IsGranted("ROLE_ADMIN")
     * @Route("/{id}/edit", name="commande_edit_back", methods={"GET", "POST"})
     */
    public function editback(Request $request, Commande $commande, EntityManagerInterface $entityManager): Response
    {
        $form = $this->createForm(CommandeType::class, $commande);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->flush();

            return $this->redirectToRoute('commande_Back', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('commande_Back/editback.html.twig', [
            'commande' => $commande,
            'form' => $form->createView(),
        ]);
    }

/**
     * @Route("/confirmer_commande/{id}", name="confirmer_commande", methods={"GET", "POST"})
     */
    public function confirmer_commande(Request $request, Commande $commande, EntityManagerInterface $entityManager): Response
    {
        $commande->setEtatCmde(true);
        $entityManager->persist($commande);
        $entityManager->flush();
        return $this->redirectToRoute('commande_Back', [], Response::HTTP_SEE_OTHER);

    }

    /**
     * @Route("/annuler_commande/{id}", name="annuler_commande", methods={"GET", "POST"})
     */
    public function annuler_commande(Request $request,  Commande $commande,  EntityManagerInterface $entityManager): Response
    {
        $commande->setEtatCmde(false);
        $entityManager->persist($commande);
        $entityManager->flush();
        return $this->redirectToRoute('commande_Back', [], Response::HTTP_SEE_OTHER);

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
     * @Route("/AddCommande/new", name="AddCommande/new")
    */
    public function Addcmde(Request $request, NormalizerInterface $Normalizer )
    {
        $entityManager = $this->getDoctrine()->getManager();
        $commande = new Commande();
        $commande->setRefCmde($request->get('ref_cmde'));
        $commande->setEtatCmde($request->get('etat_cmde'));
        $commande->setProd($request->get('prod'));
        $commande->setPays($request->get('Pays'));
        $commande->setRegion($request->get('Region'));
        $commande->setCodePostal($request->get('code_postal'));
        $commande->setTel($request->get('tel'));
        //$commande->setUser($request->get('user'));
        $entityManager->persist($commande);
        $entityManager->flush();
    
        $jsonContent=$Normalizer->normalize($commande,'json',['groups'=>'post:read']);
        return new Response(json_encode($jsonContent));
    }


    

  /**
     * @Route("/editcmde/{id}", name="commande_edit")
     * @Method("PUT")
     */
    public function editcmde(Request $request, NormalizerInterface $Normalizer,$id)
    {
        $entityManager = $this->getDoctrine()->getManager();
        $commande = $entityManager->getRepository(Commande::class)->find($id);
        $commande->setRefCmde($request->get('ref_cmde'));
        $commande->setEtatCmde($request->get('etat_cmde'));
        $commande->setProd($request->get('prod'));
        $commande->setPays($request->get('Pays'));
        $commande->setRegion($request->get('Region'));
        $commande->setCodePostal($request->get('code_postal'));
        $commande->setTel($request->get('tel'));
        //$commande->setUser($request->get('user'));
        $entityManager->flush();

        $jsonContent=$Normalizer->normalize($commande,'json',['groups'=>'post:read']);
        return new Response("commande updated".json_encode($jsonContent));
    }






}
