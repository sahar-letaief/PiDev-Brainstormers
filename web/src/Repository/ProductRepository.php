<?php

namespace App\Repository;

use App\Entity\Product;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @method Product|null find($id, $lockMode = null, $lockVersion = null)
 * @method Product|null findOneBy(array $criteria, array $orderBy = null)
 * @method Product[]    findAll()
 * @method Product[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class ProductRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Product::class);
    }
    public function orderByPrix()
    {
        return $this->createQueryBuilder('Product')
            ->orderBy('Product.Price', 'ASC')
            ->getQuery()->getResult();
    }

   

    public function search($term,$description) {
        if($term !==null && $description==null){
        return $this->createQueryBuilder('p')
            ->andWhere('p.ProductName LIKE :prod')
            ->setParameter('prod', '%'.$term.'%')
            ->getQuery()
            ->getResult();
         }
        elseif ($term ==null && $description!==null){
            return $this->createQueryBuilder('p')

                ->andWhere('p.Description LIKE :description')
                ->setParameter('description', '%'.$description.'%')
                ->getQuery()
                ->getResult();



        }else{
            return $this->createQueryBuilder('p')
                ->andWhere('p.ProductName LIKE :prod')
                ->andWhere('p.Description LIKE :description')
                ->setParameter('description', '%'.$description.'%')
                ->setParameter('prod', '%'.$term.'%')
                ->getQuery()
                ->getResult();


        }
    }


    public function findByPriceRange($minValue,$maxValue)
    {
        return $this->createQueryBuilder('p')
            ->andWhere('p.Price >= :minVal')
            ->setParameter('minVal', $minValue)
            ->andWhere('p.Price <= :maxVal')
            ->setParameter('maxVal', $maxValue)
            ->orderBy('p.id', 'ASC')
            ->setMaxResults(10)
            ->getQuery()
            ->getResult()
        ;
    }
    

    // /**
    //  * @return Product[] Returns an array of Product objects
    //  */
    /*
    public function findByExampleField($value)
    {
        return $this->createQueryBuilder('p')
            ->andWhere('p.exampleField = :val')
            ->setParameter('val', $value)
            ->orderBy('p.id', 'ASC')
            ->setMaxResults(10)
            ->getQuery()
            ->getResult()
        ;
    }
    */

    /*
    public function findOneBySomeField($value): ?Product
    {
        return $this->createQueryBuilder('p')
            ->andWhere('p.exampleField = :val')
            ->setParameter('val', $value)
            ->getQuery()
            ->getOneOrNullResult()
        ;
    }
    */
}
