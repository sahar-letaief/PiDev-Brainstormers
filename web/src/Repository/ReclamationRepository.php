<?php

namespace App\Repository;

use App\Entity\Reclamation;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @method Reclamation|null find($id, $lockMode = null, $lockVersion = null)
 * @method Reclamation|null findOneBy(array $criteria, array $orderBy = null)
 * @method Reclamation[]    findAll()
 * @method Reclamation[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class ReclamationRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Reclamation::class);
    }

    // /**
    //  * @return Reclamation[] Returns an array of Reclamation objects
    //  */
    /*
    public function findByExampleField($value)
    {
        return $this->createQueryBuilder('r')
            ->andWhere('r.exampleField = :val')
            ->setParameter('val', $value)
            ->orderBy('r.id', 'ASC')
            ->setMaxResults(10)
            ->getQuery()
            ->getResult()
        ;
    }
    */

    /*
    public function findOneBySomeField($value): ?Reclamation
    {
        return $this->createQueryBuilder('r')
            ->andWhere('r.exampleField = :val')
            ->setParameter('val', $value)
            ->getQuery()
            ->getOneOrNullResult()
        ;
    }
    */
  /*  public function search($term) {
        return $this->createQueryBuilder('r')
            ->andWhere('r.Title LIKE :title')
            ->setParameter('title', '%'.$term.'%')
            ->getQuery()
            ->execute();
    }*/
   /* public function search($title,$description,$create,$resolution) {

            return $this->createQueryBuilder('p')
                ->andWhere('p.Title LIKE :titre')
                ->setParameter('titre', '%'.$title.'%')
                ->andWhere('p.Description LIKE :descrip')
                ->setParameter('descrip', '%'.$description.'%')
                ->andWhere('p.create_date LIKE :create')
                ->setParameter('create', '%'.$create.'%')
                ->andWhere('p.create_resolution LIKE :resolu')
                ->setParameter('resolu', '%'.$resolution.'%')
                ->getQuery()
                ->getResult();
        }*/

    /*public function search($term) {
        if($term ==Title ){
            return $this->createQueryBuilder('p')
                ->andWhere('p.Title LIKE :titre')
                ->setParameter('titre', '%'.$term.'%')
                ->getQuery()
                ->getResult();
        }
        elseif ($term ==Description){
            return $this->createQueryBuilder('p')

                ->andWhere('p.Description LIKE :des')
                ->setParameter('des', '%'.$term.'%')
                ->getQuery()
                ->getResult();



        }
        elseif ($term == create_resolution) {
            return $this->createQueryBuilder('p')
                ->andWhere('p.create_resolution LIKE :res')
                ->setParameter('res', '%'.$term.'%')
                ->getQuery()
                ->getResult();
        }else{
            return $this->createQueryBuilder('p')
                ->andWhere('p.create_date LIKE :create')
                ->setParameter('create', '%'.$term.'%')
                ->getQuery()
                ->getResult();
        }

        /*else{
            return $this->createQueryBuilder('p')
                ->andWhere('p.ProductName LIKE :prod')
                ->andWhere('p.Description LIKE :description')
                ->setParameter('description', '%'.$description.'%')
                ->setParameter('prod', '%'.$term.'%')
                ->getQuery()
                ->getResult();


        }*/
    public function search($term,$description) {
        if($term !==null && $description==null){
            return $this->createQueryBuilder('p')
                ->andWhere('p.Title LIKE :prod')
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
                ->andWhere('p.Title LIKE :prod')
                ->andWhere('p.Description LIKE :description')
                ->setParameter('description', '%'.$description.'%')
                ->setParameter('prod', '%'.$term.'%')
                ->getQuery()
                ->getResult();


        }
    }


    }


