<?php

namespace App\Controller;

use App\Entity\ImagesEvents;
use App\Entity\User;
use App\Form\ImagesEventsType;
use App\Repository\EvenementRepository;
use App\Repository\ImagesEventsRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use App\Form\EditUserType;
use App\Form\PasswordProfileType;
use App\Form\ProfileType;
use App\Form\UserType;
use App\Repository\UserRepository;
use Knp\Component\Pager\PaginatorInterface;
use phpDocumentor\Reflection\Types\Nullable;
use Symfony\Component\Security\Core\Authentication\Token\UsernamePasswordToken;
use Symfony\Component\Security\Core\Encoder\UserPasswordEncoderInterface;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\IsGranted;
use Symfony\Component\Security\Core\User\UserInterface;
use Symfony\Component\Security\Csrf\TokenStorage\TokenStorageInterface;
use Symfony\Component\Serializer\Normalizer\NormalizerInterface;
/**
 * @Route("/images/events")
 */
class ImagesEventsController extends AbstractController
{

    /**
     * @IsGranted("ROLE_USER")
     * @Route("/new", name="images_events_new", methods={"GET", "POST"})
     */
    public function new(Request $request, EntityManagerInterface $entityManager, EvenementRepository $eventRepository): Response
    {
dd($this->getUser());
        $imagesEvent = new ImagesEvents();
        $form = $this->createForm(ImagesEventsType::class, $imagesEvent);
        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid()) {
            $user = new User();
            $user = $this->getUser();
            $event = $eventRepository->findOneBy(['id' => $id]);
            $images = $form->get('image')->getData();
            foreach ($images as $image){
                // on generer un nv nom du fichier
                $fichier = md5(uniqid()) . '.' . $image->guessExtension();

                //on copie le fichier dans le dossier uploads
                $image->move(
                    $this->getParameter('images_directory'),
                    $fichier
                );

                // on stock l'image dans la base de données
                $imagesEvent->setImage($fichier);
                $imagesEvent->setIdEvent($event);

                dump($imagesEvent);
            }
            dd($imagesEvent,$this->getUser());
            $entityManager->persist($imagesEvent);
            $entityManager->flush();

            return $this->redirectToRoute('images_events_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('images_events/new.html.twig', [
            'images_event' => $imagesEvent,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/", name="images_events_index", methods={"GET"})
     */
    public function index(ImagesEventsRepository $imagesEventsRepository): Response
    {
        return $this->render('images_events/index.html.twig', [
            'images_events' => $imagesEventsRepository->findAll(),
        ]);
    }


    /**
     * @Route("/{id}", name="images_events_show", methods={"GET"})
     */
    public function show(ImagesEvents $imagesEvent): Response
    {
        return $this->render('images_events/show.html.twig', [
            'images_event' => $imagesEvent,
        ]);
    }

    /**
     * @Route("/{id}/edit", name="images_events_edit", methods={"GET", "POST"})
     */
    public function edit(Request $request, ImagesEvents $imagesEvent, EntityManagerInterface $entityManager): Response
    {
        $form = $this->createForm(ImagesEventsType::class, $imagesEvent);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->flush();

            return $this->redirectToRoute('images_events_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('images_events/edit.html.twig', [
            'images_event' => $imagesEvent,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="images_events_delete", methods={"POST"})
     */
    public function delete(Request $request, ImagesEvents $imagesEvent, EntityManagerInterface $entityManager): Response
    {
        if ($this->isCsrfTokenValid('delete'.$imagesEvent->getId(), $request->request->get('_token'))) {
            $entityManager->remove($imagesEvent);
            $entityManager->flush();
        }

        return $this->redirectToRoute('images_events_index', [], Response::HTTP_SEE_OTHER);
    }
}
