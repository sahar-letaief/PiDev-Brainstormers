<?php

namespace App\Controller;

use App\Entity\Product;
use App\Form\ProductType;
use App\Form\ProductSearchType;
use App\Repository\ProductRepository;
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
use Sensio\Bundle\FrameworkExtraBundle\Configuration\IsGranted;






/**
 * @Route("/product")
 */
class ProductController extends AbstractController
{
       
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
     * @IsGranted("ROLE_PRODUCT")
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
     * @IsGranted("ROLE_PRODUCT")
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
     * @IsGranted("ROLE_PRODUCT")
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
     * @IsGranted("ROLE_PRODUCT")
     * @Route("/{id}", name="product_show", methods={"GET"})
     */
    public function show(Product $product, TranslatorInterface $translator): Response
    {
        return $this->render('product/show.html.twig', [
            'product' => $product,
        ]);
    }
    /**
     * @Route("/Front/{id}", name="product_show_front", methods={"GET"})
     */
    public function showFront(Product $product): Response
    {
        return $this->render('product/showFront.html.twig', [
            'product' => $product,
        ]);
    }
    

    /**
     * @IsGranted("ROLE_PRODUCT")
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
     * @IsGranted("ROLE_PRODUCT")
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
