<?php

namespace App\Form;

use App\Entity\Commande;
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
        $length = 10;    
        $ref = substr(str_shuffle('0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ'),1,$length) ;
        $builder
            ->add('ref_cmde', TextType::class, [
               'attr' => [
                       'placeholder' => "ex: ref",
                       'value' => $ref,
                       'data' => $ref,
                       ]])
            //->add('date_cmde', DateTimeType::class,[
                   // 'label' => 'Date de début',
                    //'widget' => 'single_text',
                    //'html5' => false,
                    ////'attr' => ['class' => 'js-datepicker'],
                    //'format' => 'dd/MM/yyyy',
                    //'input' => 'string',
                    //'input_format' => 'Y-m-d'
                //])
            ->add('pays', TextType::class, [
               'attr' => [
                       'placeholder' => "ex: Pays"]])

            ->add('region', TextType::class, [
               'attr' => [
                       'placeholder' => "ex: Region/Département"]])

            ->add('code_postal', TextType::class, [
               'attr' => [
                       'placeholder' => "ex: Code postal"]])

            ->add('tel', TextType::class, [
               'attr' => [
                       'placeholder' => "ex: Numéro de téléphone"]]) 
            ->add('etat_cmde', CheckboxType::class, [
                'required' => false,
            ])  
            ->add('Enregistrer', SubmitType::class);      
        ;
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            'data_class' => Commande::class,
        ]);
    }
}
