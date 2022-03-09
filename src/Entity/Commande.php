<?php

namespace App\Entity;
use App\Entity\Reclamation;
use App\Repository\CommandeRepository;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;
use Symfony\Component\Serializer\Annotation\Groups;

/**
 * @ORM\Entity(repositoryClass=CommandeRepository::class)
 */
class Commande
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
     */
    private $ref_cmde;

    /**
     * @ORM\Column(type="boolean", nullable= true, options={"default" : null})
     * @Groups("post:read")
     * 
     */
    private $etat_cmde;

    /**
     * 
     * @ORM\Column(type="date",nullable=false)
     * @Assert\NotBlank
     * @Groups("post:read")
     */
    //private $date_cmde;

    /**
     * @ORM\ManyToMany(targetEntity=Product::class, mappedBy="commande")
     */
    private $products;

    /**
     * @ORM\Column(type="array")
     * @Groups("post:read")
     */
    private $prod = [];

    /**
     * @ORM\Column(type="string", length=255)
     * @Assert\NotNull
     * @Groups("post:read")
     * 
     */
    private $Pays;

    /**
     * @ORM\Column(type="string", length=255)
     * @Assert\NotNull
     * @Groups("post:read")
     * 
     */
    private $Region;

    /**
     * @ORM\Column(type="integer")
     * @Assert\NotNull
     * @Assert\Length(min="4" , minMessage="la code postal doit contenir au moins 4 caractères.")
     * @Groups("post:read")
     */
    private $code_postal;

    /**
     * @ORM\Column(type="integer")
     * @Assert\NotNull
     * @Assert\Length(min="8" , minMessage="Le numéro de téléphone doit contenir exactement 8 chiffres")
     * @Groups("post:read")
     */
    private $tel;

    /**
     * @ORM\ManyToOne(targetEntity=User::class, inversedBy="command")
     */
    private $user;




    public function __construct()
    {
        $this->products = new ArrayCollection();
    }

   

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getRefCmde(): ?string
    {
        return $this->ref_cmde;
    }

    public function setRefCmde(?string $ref_cmde): self
    {
        $this->ref_cmde = $ref_cmde;

        return $this;
    }

    public function getEtatCmde(): ?bool
    {
        return $this->etat_cmde;
    }

    public function setEtatCmde(bool $etat_cmde): self
    {
        $this->etat_cmde = $etat_cmde;

        return $this;
    }

    public function getDateCmde(): ?\DateTimeInterface
    {
        return $this->date_cmde;
    }

    public function setDateCmde(\DateTimeInterface $date_cmde): self
    {
        $this->date_cmde = $date_cmde;

        return $this;
    }

    /**
     * @return Collection|Product[]
     */
    public function getProducts(): Collection
    {
        return $this->products;
    }

    public function addProduct(Product $product): self
    {
        if (!$this->products->contains($product)) {
            $this->products[] = $product;
            $product->addCommande($this);
        }

        return $this;
    }

    public function removeProduct(Product $product): self
    {
        if ($this->products->removeElement($product)) {
            $product->removeCommande($this);
        }

        return $this;
    }

    public function getProd(): ?array
    {
        return $this->prod;
    }

    public function setProd(?array $prod): self
    {
        $this->prod = $prod;

        return $this;
    }

    public function getPays(): ?string
    {
        return $this->Pays;
    }

    public function setPays(?string $Pays): self
    {
        $this->Pays = $Pays;

        return $this;
    }

    public function getRegion(): ?string
    {
        return $this->Region;
    }

    public function setRegion(?string $Region): self
    {
        $this->Region = $Region;

        return $this;
    }

    public function getCodePostal(): ?int
    {
        return $this->code_postal;
    }

    public function setCodePostal(int $code_postal): self
    {
        $this->code_postal = $code_postal;

        return $this;
    }

    public function getTel(): ?int
    {
        return $this->tel;
    }

    public function setTel(int $tel): self
    {
        $this->tel = $tel;

        return $this;
    }

    public function getUser(): ?User
    {
        return $this->user;
    }

    public function setUser(?User $user): self
    {
        $this->user = $user;

        return $this;
    }
 public function __toString()
    {
        return $this->ref_cmde;
    }
}
