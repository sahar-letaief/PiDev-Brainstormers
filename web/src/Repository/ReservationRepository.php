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
            ->createQuery("SELECT r FROM APP\Entity\Reservation r JOIN r.evenement n WHERE n.NameEvent=:NameEvent ")
            ->setParameter('NameEvent',$NameEvent)
           ->getResult();
    }
    public function findByFirstName($firstname){
        $entityManager=$this->getEntityManager();
        return $entityManager->createQuery("SELECT r from APP\Entity\Reservation r JOIN r.user u where u.firstname=:firstname")
            ->setParameter('firstname',$firstname)
            ->getResult();
    }

    public function findByLastName($lastname){
        $entityManager=$this->getEntityManager();
        return $entityManager->createQuery("SELECT r from APP\Entity\Reservation r JOIN r.user u where u.lastname=:lastname")
            ->setParameter('lastname',$lastname)
            ->getResult();
    }
    public function findByEmail($email){
        $entityManager=$this->getEntityManager();
        return $entityManager->createQuery("SELECT r from APP\Entity\Reservation r JOIN r.user u where u.email=:email")
            ->setParameter('email',$email)
            ->getResult();
    }
}
