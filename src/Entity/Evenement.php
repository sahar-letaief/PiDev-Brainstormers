<?php

namespace App\Entity;

use App\Repository\EvenementRepository;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;
use Symfony\Bridge\Doctrine\Validator\Constraints\UniqueEntity;
use Symfony\Component\Serializer\Annotation\Groups;


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
     * @Groups("post:read")
     */
    private $id;



    /**
     * @ORM\Column(type="string", length=255)
     * @Groups("post:read")
     * @Assert\NotBlank (message="Event name field cannot be empty")
     *  @Assert\Regex("/^[A-Z][a-z]*\s[a-z]*|[0-9]$/" ,
     *          message="Event name should be like this format Xxx xxx"
     * )
     */
    private $NameEvent;

    /**
     * @ORM\Column(type="string", length=255)
     * @Groups("post:read")
     * @Assert\NotBlank (message="Event place field cannot be empty")
     */
    private $PlaceEvent;


    /**
     * @ORM\Column(type="integer")
     * @Groups("post:read")
     * @Assert\NotEqualTo(
     *     value=0,
     *     message="Number of participants can not be equal to {{ value }} ")
     * @Assert\NotBlank(message="Number of participants field cannot be empty")
     */
    private $NbParticipants;


    /**
     * @ORM\Column(type="float")
     * @Groups("post:read")
     * @Assert\NotEqualTo(
     *     value=0,
     *     message="Ticket price can not be equal to {{ value }} DT")
     * @Assert\NotBlank(message="Ticket price field cannot be empty")
     */
    private $PriceEvent;




    /**
     * @ORM\OneToMany(targetEntity=Reservation::class, mappedBy="evenement")
     * @Groups("post:read")
     */
    private $reservations;



    /**
     * @Assert\GreaterThan("today")
     * @ORM\Column(type="date")
     * @Groups("post:read")
     */
    private $DateDebut;

    /**
     * @ORM\Column(type="date")
     * @Groups("post:read")
     * @Assert\GreaterThanOrEqual(propertyPath="DateDebut",
                         message="End event date should be greater than begin event date")
     * @Assert\GreaterThan("today")
     */
    private $DateFin;

    /**
     * @ORM\OneToMany(targetEntity=ImagesEvents::class, mappedBy="idEvent", orphanRemoval=true)
     */
    private $imagesEvents;

















    public function __construct()
    {
        $this->Reservations = new ArrayCollection();
        $this->events = new ArrayCollection();
        $this->reservations = new ArrayCollection();
        $this->imagesEvents = new ArrayCollection();
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



    public function getDateDebut(): ?\DateTimeInterface
    {
        return $this->DateDebut;
    }

    public function setDateDebut(\DateTimeInterface $DateDebut): self
    {
        $this->DateDebut = $DateDebut;

        return $this;
    }

    public function getDateFin(): ?\DateTimeInterface
    {
        return $this->DateFin;
    }

    public function setDateFin(\DateTimeInterface $DateFin): self
    {
        $this->DateFin = $DateFin;

        return $this;
    }

    /**
     * @return Collection<int, ImagesEvents>
     */
    public function getImagesEvents(): Collection
    {
        return $this->imagesEvents;
    }

    public function addImagesEvent(ImagesEvents $imagesEvent): self
    {
        if (!$this->imagesEvents->contains($imagesEvent)) {
            $this->imagesEvents[] = $imagesEvent;
            $imagesEvent->setIdEvent($this);
        }

        return $this;
    }

    public function removeImagesEvent(ImagesEvents $imagesEvent): self
    {
        if ($this->imagesEvents->removeElement($imagesEvent)) {
            // set the owning side to null (unless already changed)
            if ($imagesEvent->getIdEvent() === $this) {
                $imagesEvent->setIdEvent(null);
            }
        }

        return $this;
    }










}
