<?php

namespace App\Form;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Component\Form\Extension\Core\Type\IntegerType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\Extension\Core\Type\TextType;

class ProductSearchType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
            ->add('ProductName', TextType::class, array('label' => false,'attr' => ['placeholder' => "Enter product name"]))   
            ->add('Description', TextType::class, array('label' => false,'attr' => ['placeholder' => "Enter description"]))
            ->add('Search', SubmitType::class);
                      
            
        
    }
    
}
