<?php

namespace App\Entity;

use App\Repository\EvenementRepository;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;
use Symfony\Bridge\Doctrine\Validator\Constraints\UniqueEntity;


/**
 * @ORM\Entity(repositoryClass=EvenementRepository::class)
 * @UniqueEntity(fields={"NameEvent"}, message="There is already an event with this name")
 */
class Evenement
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     */
    private $id;



    /**
     * @ORM\Column(type="string", length=255)
     * @Assert\NotBlank (message="Event name field cannot be empty")
     *  @Assert\Regex("/^[A-Z][a-z]*$/" ,
     *          message="Event name should start with a capital"
     * )
     */
    private $NameEvent;

    /**
     * @ORM\Column(type="string", length=255)
     * @Assert\NotBlank (message="Event place field cannot be empty")
     */
    private $PlaceEvent;

    /**
     * @ORM\Column(type="date")
     * @Assert\GreaterThan("today")
     */
    private $DateEvent;

    /**
     * @ORM\Column(type="integer")
     * @Assert\NotEqualTo(
     *     value=0,
     *     message="Number of participants can not be equal to {{ value }} ")
     * @Assert\NotBlank(message="Number of participants field cannot be empty")
     */
    private $NbParticipants;
    /**
     * @ORM\Column(type="float")
     * @Assert\NotEqualTo(
     *     value=0,
     *     message="Ticket price can not be equal to {{ value }} DT")
     * @Assert\NotBlank(message="Ticket price field cannot be empty")
     */
    private $PriceEvent;




    /**
     * @ORM\OneToMany(targetEntity=Reservation::class, mappedBy="evenement")
     */
    private $reservations;













    public function __construct()
    {
        $this->Reservations = new ArrayCollection();
        $this->events = new ArrayCollection();
        $this->reservations = new ArrayCollection();
    }

    public function getId(): ?int
    {
        return $this->id;
    }





    public function getNameEvent(): ?string
    {
        return $this->NameEvent;
    }

    public function setNameEvent(string $NameEvent): self
    {
        $this->NameEvent = $NameEvent;

        return $this;
    }

    public function getPlaceEvent(): ?string
    {
        return $this->PlaceEvent;
    }

    public function setPlaceEvent(string $PlaceEvent): self
    {
        $this->PlaceEvent = $PlaceEvent;

        return $this;
    }

    public function getDateEvent(): ?\DateTimeInterface
    {
        return $this->DateEvent;
    }

    public function setDateEvent(\DateTimeInterface $DateEvent): self
    {
        $this->DateEvent = $DateEvent;

        return $this;
    }

    public function getNbParticipants(): ?int
    {
        return $this->NbParticipants;
    }

    public function setNbParticipants(int $NbParticipants): self
    {
        $this->NbParticipants = $NbParticipants;

        return $this;
    }
    public function getPriceEvent(): ?float
    {
        return $this->PriceEvent;
    }

    public function setPriceEvent(float $PriceEvent): self
    {
        $this->PriceEvent = $PriceEvent;

        return $this;
    }


    public function getEvents(): ?self
    {
        return $this->Events;
    }

    public function setEvents(?self $Events): self
    {
        $this->Events = $Events;

        return $this;
    }

    /**
     * @return Collection|Reservation[]
     */
    public function getReservations(): Collection
    {
        return $this->reservations;
    }

    public function addReservation(Reservation $reservation): self
    {
        if (!$this->reservations->contains($reservation)) {
            $this->reservations[] = $reservation;
            $reservation->setEvenement($this);
        }

        return $this;
    }

    public function removeReservation(Reservation $reservation): self
    {
        if ($this->reservations->removeElement($reservation)) {
            // set the owning side to null (unless already changed)
            if ($reservation->getEvenement() === $this) {
                $reservation->setEvenement(null);
            }
        }

        return $this;
    }










}
