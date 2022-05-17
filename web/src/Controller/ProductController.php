<?php

namespace App\Controller;

use App\Entity\Product;
use App\Form\ProductType;
use App\Form\ProductSearchType;
use App\Repository\ProductRepository;
use App\Repository\CategoryRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Knp\Component\Pager\PaginatorInterface;
use App\Entity\Category;
use App\Form\CategoryType;
use App\Entity\CategorySearch;
use App\Form\CategorySearchType;
use App\Entity\PriceSearch;
use App\Form\PriceSearchType;
use Symfony\Contracts\Translation\TranslatorInterface;
use Symfony\Component\Serializer\Normalizer\NormalizerInterface;


use Symfony\Component\Serializer\Normalizer\ObjectNormalizer;
use Symfony\Component\Serializer\Serializer;
use Symfony\Component\Serializer\Encoder\JsonEncoder;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Method;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\IsGranted;







/**
 * @Route("/product")
 */
class ProductController extends AbstractController
{
     /**
     * @Route("/FrontProductJson", name="productFront_indexJson", methods={"GET"})
     */
    public function allProductFrontJson(Request $request, ProductRepository $productRepository, PaginatorInterface $paginator, NormalizerInterface $Normalizer): Response
    {
        $products=$productRepository->orderByPrix();
        $prod = $paginator->paginate($products,$request->query->getInt('page', 1),9);

        
        $jsonContent=$Normalizer->normalize( $products,'json',['groups'=>'post:read']);
        return new Response(json_encode($jsonContent));
        dump($jsonContent);
        die;
    }

    
    /**
     * @Route("/newJson", name="product_newJson", methods={"GET", "POST"})
     */
    public function newJson(Request $request, NormalizerInterface $Normalizer,CategoryRepository $repository )
    {
        $entityManager = $this->getDoctrine()->getManager();
        $prod = new Product();
        $ag= $repository->find($request->get('Category'));
        $prod->setProductName($request->get('ProductName'));
        $prod->setDescription($request->get('Description'));
        $prod->setPrice($request->get('Price'));
        $prod->setStock($request->get('Stock'));
        $prod->setReference($request->get('Reference'));
        $prod->setCategory($ag);
        $prod->setImage("d");
        //$commande->setUser($request->get('user'));
        $entityManager->persist($prod);
        $entityManager->flush();
    
        $jsonContent=$Normalizer->normalize($prod,'json',['groups'=>'post:read']);
        return new Response(json_encode($jsonContent));
    }

    /**
    * @Route("/del", name="del")
    * @Method("DELETE")
    */

    public function delJSON(Request $request) {
        $id = $request->get("id");

        $em = $this->getDoctrine()->getManager();
        $agence = $em->getRepository(Product::class)->find($id);
        if($agence!=null ) {
            $em->remove($agence);
            $em->flush();

            $serialize = new Serializer([new ObjectNormalizer()]);
            $formatted = $serialize->normalize("Agence a ete supprimee avec success.");
            return new JsonResponse($formatted);

        }else{
            return new JsonResponse("id agence invalide.");}


    }
    /**
     * @Route("/update", name="update")
     * @Method("PUT")
     */
    public function updateJSON(Request $request) {
        $em = $this->getDoctrine()->getManager();
        $agence = $this->getDoctrine()->getManager()
            ->getRepository(Product::class)
            ->find($request->get("id"));

        $agence->setProductName($request->get("ProductName"));
        $agence->setDescription($request->get("Description"));
        $agence->setPrice($request->get('Price'));
        $agence->setStock($request->get('Stock'));


        // $agence->setVideo($request->get("Video"));

        $em->persist($agence);
        $em->flush();
        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($agence);
        return new JsonResponse("Agence a ete modifiee avec success.");

    }

    /**
     * @Route("/{id}/editJson", name="product_editJson", methods={"GET","POST"})
     */
    public function editJson(Request $request, Product $product, EntityManagerInterface $entityManager, $id,NormalizerInterface $Normalizer): Response
    {
        $em = $this->getDoctrine()->getManager();
        $Product = $this->getDoctrine()->getRepository(Product::class)->find($id);
        $Product->setProductName($request->get('ProductName'));
        $Product->setDescription($request->get('Description'));
        $Product->setPrice($request->get('Price'));
        //$Product->setStock($request->get('Stock'));
        //$Product->setReference($request->get('Reference'));
        $Product->setImage("d");

        //$Product->setDate($request->get('Date'));
        $em->flush();
        $jsonContent = $Normalizer->normalize($Product,'json',['groups'=>'post:read']);
        return new Response("Update successfully".json_encode($jsonContent));
    
        
    }
    /**
     * @Route("/{id}/deleteJson", name="product_deleteJson")
     */
    public function deleteJson(ProductRepository $set,$id,NormalizerInterface $Normalizer)
    {
        /*$product=$this->getDoctrine()->getRepository(Product::class)->find($id);
        $em=$this->getDoctrine()->getManager();
        $em->remove($product);
        $em->flush();
        return $this-> redirectToRoute('product_index');*/
        $em = $this->getDoctrine()->getManager();
        $Voyage = $this->getDoctrine()->getRepository(Product::class)->find($id);
        $em->remove($Voyage);
        $em->flush();
        $jsonContent = $Normalizer->normalize($Voyage,'json',['groups'=>'post:read']);
        return new Response("Delete successfully".json_encode($jsonContent));
    }
       
    /**
     * @Route("/FrontProduct", name="productFront_index", methods={"GET","POST"})
     */
    public function allProductFront(Request $request, ProductRepository $productRepository, PaginatorInterface $paginator): Response
    {
        $products=$productRepository->orderByPrix();
        $prod = $paginator->paginate($products,$request->query->getInt('page', 1),9);

        
        return $this->render('product/indexFront.html.twig', [
            'products' => $prod,
        ]);
    }
    /**
     * @IsGranted("ROLE_USER")
     * @Route("/FrontProduct/{categoryid}", name="product_index_front", methods={"GET"})
     */
    public function frontProduct($categoryid ,ProductRepository $productRepository): Response
    {
        $products = $productRepository->findBy(['Category' => $categoryid]);
        return $this->render('product/frontProduct.html.twig', [
            'products' => $products,
        ]);
    }
    //Recherche par catégorie
    /**
     * @IsGranted("ROLE_USER")
     * @Route("/prod_cat/", name="product_par_cat", methods={"GET","POST"})
     */

    public function productParCategory(Request $request, ProductRepository $productRepository) {
    $categorySearch = new CategorySearch();
    $form = $this->createForm(CategorySearchType::class,$categorySearch);
    $form->handleRequest($request);

    $products= [];

    if($form->isSubmitted() && $form->isValid()) {
      $category = $categorySearch->getCategory();
     
      if ($category!="") 
      {
        
        $products= $category->getProducts();
       // ou bien 
       //$products= $this->getDoctrine()->getRepository(Product::class)->findBy(['category' => $category] );
      }
      
    }
    else {  
        $products=$productRepository->orderByPrix();

    }
    
    return $this->render('product/productParCat.html.twig',['form' => $form->createView(),'products' => $products]);
    }
    //Filtre par prix
     /**
     * @IsGranted("ROLE_USER")
     * @Route("/prod_prix/", name="product_par_prix", methods={"GET","POST"})
     * 
     */
    public function productParPrice(Request $request, ProductRepository $productRepository)
    {
     
      $priceSearch = new PriceSearch();
      $form = $this->createForm(PriceSearchType::class,$priceSearch);
      $form->handleRequest($request);

      $products= [];

      if($form->isSubmitted() && $form->isValid()) {
        $minPrice = $priceSearch->getMinPrice(); 
        $maxPrice = $priceSearch->getMaxPrice();
          
        $products= $this->getDoctrine()->getRepository(Product::class)->findByPriceRange($minPrice,$maxPrice);
      }
      else {  
        $products=$productRepository->orderByPrix();

    }
    
    return  $this->render('product/productParPrice.html.twig',[ 'form' =>$form->createView(), 'products' => $products]);


    }



    /**
     * @IsGranted("ROLE_ADMIN")
     * @Route("/", name="product_index", methods={"GET","POST"})
     */
    public function index(Request $request, PaginatorInterface $paginator, ProductRepository $ProductRepository, TranslatorInterface $translator): Response
      {

        $form = $this->createForm(ProductSearchType::class);
        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid())
           {
                $term = $form['ProductName']->getData();

                $description = $form['Description']->getData();
                $products= $ProductRepository->search($term,$description);
            }
        else
            {
                $products= $ProductRepository->findAll(); 
            }
        //$products = $this->getDoctrine()->getRepository(Product::class)->findAll();
        $products2 = $paginator->paginate($products,$request->query->getInt('page', 1),3);

        return $this->render('product/index.html.twig', [
            'products' => $products2,
            'form'=> $form->createView()
        ]);
    }


    /**
     * @IsGranted("ROLE_ADMIN")
     * @Route("/new", name="product_new", methods={"GET", "POST"})
     */
    public function new(Request $request, EntityManagerInterface $entityManager, TranslatorInterface $translator): Response
    {
        $product = new Product();
        $form = $this->createForm(ProductType::class, $product);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {

            $file= $request->files->get('product')['image'];

            $uploads_directory=$this->getParameter('uploads_directory');
            $file_name=md5(uniqid())    . '.'   . $file->guessExtension();
            $file->move(
                $uploads_directory,
                $file_name
            );
            $product->setImage($file_name);
            $entityManager = $this->getDoctrine()->getManager();

                  

            $entityManager->persist($product);
            $entityManager->flush();
            $request->getSession()->getFlashBag();
            $this->addFlash(
                'success',
                'Added Successfully!'
            );

            return $this->redirectToRoute('product_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('product/new.html.twig', [
            'product' => $product,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @IsGranted("ROLE_ADMIN")
     * @Route("/{id}", name="product_show", methods={"GET"})
     */
    public function show(Product $product, TranslatorInterface $translator): Response
    {
        return $this->render('product/show.html.twig', [
            'product' => $product,
        ]);
    }
    /**
     * @IsGranted("ROLE_USER")
     * @Route("/Front/{id}", name="product_show_front", methods={"GET"})
     */
    public function showFront(Product $product): Response
    {
        return $this->render('product/showFront.html.twig', [
            'product' => $product,
        ]);
    }
    

    /**
     * @IsGranted("ROLE_ADMIN")
     * @Route("/{id}/edit", name="product_edit", methods={"GET","POST"})
     */
    public function edit(Request $request, Product $product, EntityManagerInterface $entityManager, TranslatorInterface $translator): Response
    {
        $form = $this->createForm(ProductType::class, $product);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
                            
            $file= $request->files->get('product')['image'];

            $uploads_directory=$this->getParameter('uploads_directory');
            $file_name=md5(uniqid())    . '.'   . $file->guessExtension();
            $file->move(
                $uploads_directory,
                $file_name
            );
            $product->setImage($file_name);
            $entityManager = $this->getDoctrine()->getManager();

                  

           
            $entityManager->flush();

            return $this->redirectToRoute('product_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('product/edit.html.twig', [
            'product' => $product,
            'form' => $form->createView(),
        ]);
    }

    
    /**
     * @IsGranted("ROLE_ADMIN")
     * @Route("/{id}/delete", name="product_delete", methods={"GET","POST"})
     */
    public function delete(ProductRepository $set,$id): Response
    {
        $product=$this->getDoctrine()->getRepository(Product::class)->find($id);
        $em=$this->getDoctrine()->getManager();
        $em->remove($product);
        $em->flush();
        return $this-> redirectToRoute('product_index');
    }

  
 
}