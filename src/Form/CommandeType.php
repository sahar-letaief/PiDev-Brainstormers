<?php

namespace App\Form;

use App\Entity\Commande;
use App\Entity\User;
use App\Entity\Product;
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




class CommandeType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        // dd($options['data']->getId());
        if(!$options['data']->getId()){
            $length = 10;    
        $ref = substr(str_shuffle('0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ'),1,$length) ;
        $builder
            ->add('ref_cmde', TextType::class, [
                'label' => false,
                'attr' => [
                       'placeholder' => "ex: ref",
                       'value' => $ref,
                       'data' => $ref,
                       ]])
            ->add('pays', TextType::class, [
                'label' => false,
                'attr' => [
                       'placeholder' => "ex: Country"]])

            ->add('region', TextType::class, [
                'label' => false,
                'attr' => [
                       'placeholder' => "ex: Region/Departement"]])

            ->add('code_postal', TextType::class, [
                'label' => false,
                'attr' => [
                       'placeholder' => "ex:  Postal code"]])

            ->add('tel', TextType::class, [
                'label' => false,
                'attr' => [
                       'placeholder' => "ex: Phone number"]]) 
            ->add('etat_cmde', ChoiceType::class, array(
                'label' => false,
                'choices'  => [
                    'In progress' => null,
                    'Confirmed' => true,
                    'Canceled' => false,
                ], 
            )) 
            ->add('Enregistrer', SubmitType::class);      
        ;
        }
        else {
$length = 10;    
        $ref = substr(str_shuffle('0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ'),1,$length) ;
        $builder
            ->add('ref_cmde', TextType::class, [
                'label' => false,
                'attr' => [
                       'placeholder' => "ex: ref",
                       'value' => $options['data']->getRefCmde(),
                       'data' => $options['data']->getRefCmde(),
                       ]])
            ->add('pays', TextType::class, [
                'label' => false,
                'attr' => [
                       'placeholder' => "ex: Country"]])

            ->add('region', TextType::class, [
                'label' => false,
                'attr' => [
                       'placeholder' => "ex: Region/Departement"]])

            ->add('code_postal', TextType::class, [
                'label' => false,
                'attr' => [
                       'placeholder' => "ex:  Postal code"]])

            ->add('tel', TextType::class, [
                'label' => false,
                'attr' => [
                       'placeholder' => "ex: Phone number"]]) 
            ->add('etat_cmde', ChoiceType::class, array(
                'label' => false,
                'choices'  => [
                    'In progress' => null,
                    'Confirmed' => true,
                    'Canceled' => false,
                ],
                
            )) 
            
            ->add('Enregistrer', SubmitType::class);      
        ;
        };
        
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            'data_class' => Commande::class,
        ]);
    }
}
