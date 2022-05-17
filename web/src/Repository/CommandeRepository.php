<?php

namespace App\Repository;

use App\Entity\Commande;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @method Commande|null find($id, $lockMode = null, $lockVersion = null)
 * @method Commande|null findOneBy(array $criteria, array $orderBy = null)
 * @method Commande[]    findAll()
 * @method Commande[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class CommandeRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Commande::class);
    }

    // /**
    //  * @return Commande[] Returns an array of Commande objects
    //  */
    /*
    public function findByExampleField($value)
    {
        return $this->createQueryBuilder('c')
            ->andWhere('c.exampleField = :val')
            ->setParameter('val', $value)
            ->orderBy('c.id', 'ASC')
            ->setMaxResults(10)
            ->getQuery()
            ->getResult()
        ;
    }
    */

    /*
    public function findOneBySomeField($value): ?Commande
    {
        return $this->createQueryBuilder('c')
            ->andWhere('c.exampleField = :val')
            ->setParameter('val', $value)
            ->getQuery()
            ->getOneOrNullResult()
        ;
    }
    */

    public function commandeforuser($term) {
       return $this->createQueryBuilder('Commande')
           ->andWhere('Commande.user = :id')
           ->setParameter('id', $term)
           ->getQuery()
           ->execute();

        }


    public function search($term) {      
       $searching = $this->createQueryBuilder('Commande')
           ->andWhere('Commande.ref_cmde LIKE :ref')
           ->setParameter('ref', '%'.$term.'%')
           ->getQuery()
           ->execute();
           return ($searching);

        }

     
    //elseif ($term ==null && $description!==null){
            //return $this->createQueryBuilder('Commande')
                //->andWhere('Commande.Pays LIKE :Pays')
                //->setParameter('Pays', '%'.$description.'%')
                //->getQuery()
                //->getResult();



        //}
    //else{
            //return $this->createQueryBuilder('Commande')
              //  ->andWhere('Commande.ref_cmde LIKE :ref')
               // ->andWhere('Commande.Pays LIKE :Pays')
               // ->setParameter('ref', '%'.$description.'%')
                //->setParameter('Pays', '%'.$term.'%')
                //->getQuery()
                //->getResult();


        //}
    //}

    /**
     * @return Commande[]
     */
    public function findPlanBySujet($sujet){
        return $this->createQueryBuilder('Commande')
            ->andWhere('Commande.ref_cmde LIKE :sujet ')
            ->setParameter('sujet', '%'.$sujet.'%')
            ->getQuery()
            ->getResult();
    }

}
