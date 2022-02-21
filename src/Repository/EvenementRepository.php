<?php

namespace App\Repository;

use App\Entity\Evenement;
use App\Entity\NameEventSearch;
use App\Form\NameEventSearchType;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @method Evenement|null find($id, $lockMode = null, $lockVersion = null)
 * @method Evenement|null findOneBy(array $criteria, array $orderBy = null)
 * @method Evenement[]    findAll()
 * @method Evenement[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class EvenementRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Evenement::class);
    }

    // /**
    //  * @return Evenement[] Returns an array of Evenement objects
    //  */
    /*
    public function findByExampleField($value)
    {
        return $this->createQueryBuilder('e')
            ->andWhere('e.exampleField = :val')
            ->setParameter('val', $value)
            ->orderBy('e.id', 'ASC')
            ->setMaxResults(10)
            ->getQuery()
            ->getResult()
        ;
    }
    */

    /*
    public function findOneBySomeField($value): ?Evenement
    {
        return $this->createQueryBuilder('e')
            ->andWhere('e.exampleField = :val')
            ->setParameter('val', $value)
            ->getQuery()
            ->getOneOrNullResult()
        ;
    }
    */

   public function SearchEvent(NameEventSearch $NameEvent):array
   {
       return $this-> createQueryBuilder('event')
           ->andWhere('event.NameEvent LIKE :NameEvent')
           ->setParameter('searchTerm','%' .$NameEvent. '%')
           ->getQuery()
            ->execute();
      }
    public function findByPrice()
    {
        return $this->createQueryBuilder('e')
            ->orderBy('e.PriceEvent','ASC')
            ->getQuery()
            ->getResult()
            ;
    }
}
