<?php

namespace App\Form;

use App\Entity\User;
use App\Entity\Communication;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\Extension\Core\Type\TextareaType;
use Symfony\Component\Form\FormBuilderInterface;

use Symfony\Component\OptionsResolver\OptionsResolver;

class CommunicationType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
            ->add('title',TextareaType::class,[
                "attr"=>[
                "class" =>"form-control"
                ]
            ])
            ->add('message',TextareaType::class,[
                "attr"=>[
                    "class"=>"form-control"
                ]
            ])
         //   ->add('created_at')
           // ->add('is_read')
          //  ->add('sender')
            ->add('recipient',EntityType::class,[
                "class"=>User::class,
                "choice_label"=>"email",
                "attr"=>[
                    "class"=>"form-control "
                ]
            ])
            ->add('envoyer',SubmitType::class,[
                "attr"=>[
                    "class"=>"btn btn-primary"
                ]
            ])
        ;
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            'data_class' => Communication::class,
        ]);
    }
}
