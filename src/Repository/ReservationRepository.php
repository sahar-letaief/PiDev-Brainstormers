<?php

namespace App\Repository;

use App\Entity\Reservation;
use App\Entity\Evenement;
use App\Entity\User;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @method Reservation|null find($id, $lockMode = null, $lockVersion = null)
 * @method Reservation|null findOneBy(array $criteria, array $orderBy = null)
 * @method Reservation[]    findAll()
 * @method Reservation[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class ReservationRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Reservation::class);
    }

    // /**
    //  * @return Reservation[] Returns an array of Reservation objects
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
    public function findOneBySomeField($value): ?Reservation
    {
        return $this->createQueryBuilder('r')
            ->andWhere('r.exampleField = :val')
            ->setParameter('val', $value)
            ->getQuery()
            ->getOneOrNullResult()
        ;
    }
    */
    public function findByNameEvent($NameEvent){
        $entityManager=$this->getEntityManager();
       return $query=$entityManager
            ->createQuery("SELECT (r.evenement) as NameEvent FROM APP\Entity\Evenement e JOIN e.NameEvent n WHERE n=:NameEvent ")
            ->setParameters(array('NameEvent',$NameEvent))
           ->getResult();
    }
    public function findByFirstName($firstname){
        return $this-> createQueryBuilder('r')
            ->andWhere('r.firstname LIKE :firstname')
            ->setParameter('r.firstname','%' .$firstname. '%')
            ->getQuery()
            ->execute();
    }

    public function findByLastName($lastname){
        return $this-> createQueryBuilder('r')
            ->andWhere('app.user.lastname LIKE :lastname')
            ->setParameter('app.user.lastname','%' .$lastname. '%')
            ->getQuery()
            ->execute();
    }
    public function findByEmail($email){
        return $this-> createQueryBuilder('r')
            ->andWhere('r.user.email LIKE :email')
            ->setParameter('r.user.email','%' .$email. '%')
            ->getQuery()
            ->execute();
    }
}
