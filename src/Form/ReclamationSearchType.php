<?php

namespace App\Form;


use App\Entity\Reclamation;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Component\Form\Extension\Core\Type\CheckboxType;
use Symfony\Component\Form\Extension\Core\Type\ChoiceType;
use Symfony\Component\Form\Extension\Core\Type\FormType;
use Symfony\Component\Form\Extension\Core\Type\TextType;
use Symfony\Component\Form\Extension\Core\Type\DateTimeType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;




class ReclamationSearchType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {

        $builder
            ->add('Title', TextType::class)
           // ->add('create_date', TextType::class)
            ->add('Description', TextType::class)
           // ->add('create_resolution', TextType::class)
            ->add('Search', SubmitType::class,[
                    "attr"=>[
                        "class"=>"btn btn-primary mr-2"
                    ]
                ]);

    }
}
