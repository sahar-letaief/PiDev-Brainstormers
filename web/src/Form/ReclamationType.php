<?php

namespace App\Form;

use App\Entity\Commande;
use App\Entity\Reclamation;
use App\Entity\User;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Captcha\Bundle\CaptchaBundle\Form\Type\CaptchaType;
use Captcha\Bundle\CaptchaBundle\Validator\Constraints\ValidCaptcha;


class ReclamationType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
            ->add('reference',EntityType::class,[
                "class"=> Commande::class,
                "choice_label"=>"ref_cmde",
                "attr"=>[
        "class"=>"form-control "
            ]
            ])
            ->add('Title')
           // ->add('create_date')
          //  ->add('create_resolution')
            ->add('Description')
           //->add('Status'))
           ->add('captchaCode', CaptchaType::class, array(
            'captchaConfig' => 'ExampleCaptchaUserRegistration',
            'constraints' => [
                new ValidCaptcha([
                    'message' => 'Invalid captcha, please try again',
                ]),
            ],
        ))

        // ... ///
    ;
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            'data_class' => Reclamation::class,
        ]);
    }
}
