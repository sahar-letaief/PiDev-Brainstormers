<?php

namespace App\Entity;

use App\Repository\ReclamationRepository;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;
use Symfony\Component\Serializer\Annotation\Groups;


/**
 * @ORM\Entity(repositoryClass=ReclamationRepository::class)
 */
class Reclamation
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
     * @Assert\NotBlank(message="Nom requise")
     * @Groups("post:read")
     */
    private $Title;

    /**
     * @ORM\Column(type="date",nullable=true)
     */
    private $create_date;

    /**
     * @ORM\Column(type="date",nullable=true)

     */
    private $create_resolution;

    /**
     * @ORM\Column(type="text")
     * @Assert\NotBlank(message="Nom requise")
     * @Groups("post:read")
     */
    private $Description;

    /**
     * @ORM\Column(type="string", length=255, nullable=true)
     */
    private $Status;

    /**
     * @ORM\ManyToOne(targetEntity=Commande::class)
     * @Assert\NotBlank(message="Nom requise")
     */
    private $reference;

    protected $captchaCode;

    /**
     * @ORM\ManyToOne(targetEntity=User::class, inversedBy="reclamations")
     */
    private $clients;


    public function getId(): ?int
    {
        return $this->id;
    }

    public function getTitle(): ?string
    {
        return $this->Title;
    }

    public function setTitle(string $Title): self
    {
        $this->Title = $Title;

        return $this;
    }

    public function getCreateDate(): ?\DateTimeInterface
    {
        return $this->create_date;
    }

    public function setCreateDate(\DateTimeInterface $create_date): self
    {
        $this->create_date = $create_date;

        return $this;
    }

    public function getCreateResolution(): ?\DateTimeInterface
    {
        return $this->create_resolution;
    }

    public function setCreateResolution(\DateTimeInterface $create_resolution): self
    {
        $this->create_resolution = $create_resolution;

        return $this;
    }

    public function getDescription(): ?string
    {
        return $this->Description;
    }

    public function setDescription(string $Description): self
    {
        $this->Description = $Description;

        return $this;
    }

    public function getStatus(): ?string
    {
        return $this->Status;
    }

    public function setStatus(string $Status): self
    {
        $this->Status = $Status;

        return $this;
    }

    public function getReference(): ?Commande
    {
        return $this->reference;
    }

    public function setReference(?Commande $reference): self
    {
        $this->reference = $reference;

        return $this;
    }
    public function getCaptchaCode()
    {
        return $this->captchaCode;
    }
    public function setCaptchaCode($captchaCode)
    {
        $this->captchaCode = $captchaCode;
    }

    public function getClients(): ?User
    {
        return $this->clients;
    }

    public function setClients(?User $clients): self
    {
        $this->clients = $clients;

        return $this;
    }

}
