<?php

namespace App\Form;

use App\Entity\Evenement;
use App\Entity\Reservation;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;

class ReservationType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
            ->add('evenement',EntityType::class,['class'=>Evenement::class, 'choice_label' => 'NameEvent'])
            ->add('userFirstName',EntityType::class,['class' =>User::class])
            ->add('userLastName',EntityType::class,['class' =>User::class])
            ->add('userEmail',EntityType::class,['class' =>User::class])
            ->add('userPhone',EntityType::class,['class' =>User::class])
            ->add('DateReservation')
            ->add('Submit',submitType::class )
        ;
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            'data_class' => Reservation::class,
        ]);
    }
}
