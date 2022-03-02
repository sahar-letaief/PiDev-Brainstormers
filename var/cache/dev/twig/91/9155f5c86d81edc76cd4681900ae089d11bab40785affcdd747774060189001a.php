<?php

use Twig\Environment;
use Twig\Error\LoaderError;
use Twig\Error\RuntimeError;
use Twig\Extension\SandboxExtension;
use Twig\Markup;
use Twig\Sandbox\SecurityError;
use Twig\Sandbox\SecurityNotAllowedTagError;
use Twig\Sandbox\SecurityNotAllowedFilterError;
use Twig\Sandbox\SecurityNotAllowedFunctionError;
use Twig\Source;
use Twig\Template;

/* registration/register.html.twig */
class __TwigTemplate_781ea7d6bd9275083405935948595cf150d3a58ec37cb2d297649c8c14b74214 extends Template
{
    private $source;
    private $macros = [];

    public function __construct(Environment $env)
    {
        parent::__construct($env);

        $this->source = $this->getSourceContext();

        $this->parent = false;

        $this->blocks = [
        ];
    }

    protected function doDisplay(array $context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "registration/register.html.twig"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "registration/register.html.twig"));

        // line 1
        echo "


    <!DOCTYPE html>
    <html lang=\"en\">
    <head>
        <!-- Required meta tags -->
        <meta charset=\"utf-8\">
        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
        <title>Corona Admin</title>
        <!-- plugins:css -->
        <link rel=\"stylesheet\" href=\"";
        // line 12
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/vendors/mdi/css/materialdesignicons.min.css"), "html", null, true);
        echo "\">
        <link rel=\"stylesheet\" href=\"";
        // line 13
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/vendors/css/vendor.bundle.base.css"), "html", null, true);
        echo "\">
        <!-- endinject -->
        <!-- Plugin css for this page -->
        <!-- End plugin css for this page -->
        <!-- inject:css -->
        <!-- endinject -->
        <!-- Layout styles -->
        <link rel=\"stylesheet\" href=\"";
        // line 20
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/css/style.css"), "html", null, true);
        echo "\">
        <!-- End layout styles -->
        <link rel=\"shortcut icon\" href=\"";
        // line 22
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/images/favicon.png"), "html", null, true);
        echo "\" />

        <style>
            #registration_form_agreeTerms{
                margin-top: -16px;
            }

            ul{
                background-color: #ff2828;
                border-radius: 9px;
            }
            .card{
                border: 2px solid white;
            }
        </style>
    </head>
    <body>
    <div class=\"container-scroller\">
        <div class=\"container-fluid page-body-wrapper full-page-wrapper\">
            <div class=\"row w-100 m-0\">
                <div class=\"content-wrapper full-page-wrapper d-flex align-items-center auth login-bg\">
                    <div class=\"card col-lg-4 mx-auto\">
                        <div class=\"card-body px-5 py-5\">
                            <h3 class=\"card-title text-center mb-3\">Sign up</h3>

                            ";
        // line 47
        echo         $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->renderBlock((isset($context["registrationForm"]) || array_key_exists("registrationForm", $context) ? $context["registrationForm"] : (function () { throw new RuntimeError('Variable "registrationForm" does not exist.', 47, $this->source); })()), 'form_start', ["attr" => ["novalidate" => "novalidate"]]);
        echo "
                            ";
        // line 48
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["registrationForm"]) || array_key_exists("registrationForm", $context) ? $context["registrationForm"] : (function () { throw new RuntimeError('Variable "registrationForm" does not exist.', 48, $this->source); })()), "firstname", [], "any", false, false, false, 48), 'errors', ["attr" => ["class" => " alert alert-danger label"]]);
        echo "
                            <div class=\"input-group input-group-merge input-group-alternative mb-3\">

                                <div class=\"input-group-prepend\">
                                    <span class=\"input-group-text\"><i class=\"mdi mdi-account\"></i></span>
                                </div>
                                ";
        // line 54
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["registrationForm"]) || array_key_exists("registrationForm", $context) ? $context["registrationForm"] : (function () { throw new RuntimeError('Variable "registrationForm" does not exist.', 54, $this->source); })()), "firstname", [], "any", false, false, false, 54), 'widget', ["attr" => ["class" => "form-control p_input", "placeholder" => "first name"]]);
        echo "
                            </div>
                            ";
        // line 56
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["registrationForm"]) || array_key_exists("registrationForm", $context) ? $context["registrationForm"] : (function () { throw new RuntimeError('Variable "registrationForm" does not exist.', 56, $this->source); })()), "lastname", [], "any", false, false, false, 56), 'errors', ["attr" => ["class" => "label"]]);
        echo "
                            <div class=\"input-group input-group-merge input-group-alternative mb-3\">
                                <div class=\"input-group-prepend\">
                                    <span class=\"input-group-text\"><i class=\"mdi mdi-account\"></i></span>
                                </div>
                                ";
        // line 61
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["registrationForm"]) || array_key_exists("registrationForm", $context) ? $context["registrationForm"] : (function () { throw new RuntimeError('Variable "registrationForm" does not exist.', 61, $this->source); })()), "lastname", [], "any", false, false, false, 61), 'widget', ["attr" => ["class" => "form-control p_input", "placeholder" => "last name"]]);
        echo "
                            </div>
                            ";
        // line 63
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["registrationForm"]) || array_key_exists("registrationForm", $context) ? $context["registrationForm"] : (function () { throw new RuntimeError('Variable "registrationForm" does not exist.', 63, $this->source); })()), "email", [], "any", false, false, false, 63), 'errors', ["attr" => ["class" => "label"]]);
        echo "
                            <div class=\"input-group input-group-merge input-group-alternative mb-3\">
                                <div class=\"input-group-prepend\">
                                    <span class=\"input-group-text\"><i class=\"mdi mdi-email\"></i></span>
                                </div>
                                ";
        // line 68
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["registrationForm"]) || array_key_exists("registrationForm", $context) ? $context["registrationForm"] : (function () { throw new RuntimeError('Variable "registrationForm" does not exist.', 68, $this->source); })()), "email", [], "any", false, false, false, 68), 'widget', ["attr" => ["class" => "form-control ", "placeholder" => "email"]]);
        echo "
                            </div>
                            ";
        // line 70
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["registrationForm"]) || array_key_exists("registrationForm", $context) ? $context["registrationForm"] : (function () { throw new RuntimeError('Variable "registrationForm" does not exist.', 70, $this->source); })()), "plainPassword", [], "any", false, false, false, 70), 'errors', ["attr" => ["class" => "label"]]);
        echo "
                            <div class=\"input-group input-group-merge input-group-alternative mb-3\">
                                <div class=\"input-group-prepend\">
                                    <span class=\"input-group-text\"><i class=\"mdi mdi-lock\"></i></span>
                                </div>
                                ";
        // line 75
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["registrationForm"]) || array_key_exists("registrationForm", $context) ? $context["registrationForm"] : (function () { throw new RuntimeError('Variable "registrationForm" does not exist.', 75, $this->source); })()), "plainPassword", [], "any", false, false, false, 75), 'widget', ["attr" => ["class" => "form-control", "placeholder" => "Password", "novalidate" => "novalidate"]]);
        echo "
                            </div>
                            ";
        // line 77
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["registrationForm"]) || array_key_exists("registrationForm", $context) ? $context["registrationForm"] : (function () { throw new RuntimeError('Variable "registrationForm" does not exist.', 77, $this->source); })()), "phone_number", [], "any", false, false, false, 77), 'errors', ["attr" => ["class" => "label"]]);
        echo "
                            <div class=\"input-group input-group-merge input-group-alternative mb-3\">
                                <div class=\"input-group-prepend\">
                                    <span class=\"input-group-text\"><i class=\"mdi mdi-cellphone\"></i></span>
                                </div>
                                ";
        // line 82
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["registrationForm"]) || array_key_exists("registrationForm", $context) ? $context["registrationForm"] : (function () { throw new RuntimeError('Variable "registrationForm" does not exist.', 82, $this->source); })()), "phone_number", [], "any", false, false, false, 82), 'widget', ["attr" => ["class" => "form-control", "placeholder" => "Phone Number"]]);
        echo "
                            </div>
                            ";
        // line 84
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["registrationForm"]) || array_key_exists("registrationForm", $context) ? $context["registrationForm"] : (function () { throw new RuntimeError('Variable "registrationForm" does not exist.', 84, $this->source); })()), "usertag", [], "any", false, false, false, 84), 'errors', ["attr" => ["class" => "label"]]);
        echo "
                            <div class=\"input-group input-group-merge input-group-alternative mb-3\">
                                <div class=\"input-group-prepend\">
                                    <span class=\"input-group-text\"><i class=\"mdi mdi-cellphone\"></i></span>
                                </div>
                                ";
        // line 89
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["registrationForm"]) || array_key_exists("registrationForm", $context) ? $context["registrationForm"] : (function () { throw new RuntimeError('Variable "registrationForm" does not exist.', 89, $this->source); })()), "usertag", [], "any", false, false, false, 89), 'widget', ["attr" => ["class" => "form-control", "placeholder" => "Username"]]);
        echo "
                            </div>
                            ";
        // line 91
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["registrationForm"]) || array_key_exists("registrationForm", $context) ? $context["registrationForm"] : (function () { throw new RuntimeError('Variable "registrationForm" does not exist.', 91, $this->source); })()), "agreeTerms", [], "any", false, false, false, 91), 'errors', ["attr" => ["class" => "label"]]);
        echo "
                            <div class=\"form-group d-flex align-items-center justify-content-between\">
                                <div class=\"form-check\">
                                    ";
        // line 94
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["registrationForm"]) || array_key_exists("registrationForm", $context) ? $context["registrationForm"] : (function () { throw new RuntimeError('Variable "registrationForm" does not exist.', 94, $this->source); })()), "agreeTerms", [], "any", false, false, false, 94), 'label', ["label_attr" => ["class" => "form-check-label"], "label" => "Agree to the terms and services"]);
        echo "
                                    ";
        // line 95
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["registrationForm"]) || array_key_exists("registrationForm", $context) ? $context["registrationForm"] : (function () { throw new RuntimeError('Variable "registrationForm" does not exist.', 95, $this->source); })()), "agreeTerms", [], "any", false, false, false, 95), 'widget', ["attr" => ["class" => "form-check-input"]]);
        echo "
                                </div>
                            </div>

                            <div class=\"text-center\">
                                <button type=\"submit\" class=\"btn btn-primary btn-block enter-btn\">Sign up</button>
                            </div>
                            ";
        // line 102
        echo         $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->renderBlock((isset($context["registrationForm"]) || array_key_exists("registrationForm", $context) ? $context["registrationForm"] : (function () { throw new RuntimeError('Variable "registrationForm" does not exist.', 102, $this->source); })()), 'form_end');
        echo "
                            <div class=\"form-group d-flex align-items-center justify-content-between\">
                                <a href=\"";
        // line 104
        echo $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("app_login");
        echo "\" class=\"forgot-pass\"><small>Login</small></a>
                                <a href=\"";
        // line 105
        echo $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("app_forgotten_password");
        echo "\" class=\"forgot-pass\"><small>Forgot password?</small></a>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- content-wrapper ends -->
            </div>
            <!-- row ends -->
        </div>
        <!-- page-body-wrapper ends -->
    </div>
    <!-- container-scroller -->
    <!-- plugins:js -->
    <script src=\"";
        // line 118
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/vendors/js/vendor.bundle.base.js"), "html", null, true);
        echo "\"></script>
    <!-- endinject -->
    <!-- Plugin js for this page -->
    <!-- End plugin js for this page -->
    <!-- inject:js -->
    <script src=\"";
        // line 123
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/js/off-canvas.js"), "html", null, true);
        echo "\"></script>
    <script src=\"";
        // line 124
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/js/hoverable-collapse.js"), "html", null, true);
        echo "\"></script>
    <script src=\"";
        // line 125
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/js/misc.js"), "html", null, true);
        echo "\"></script>
    <script src=\"";
        // line 126
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/js/settings.js"), "html", null, true);
        echo "\"></script>
    <script src=\"";
        // line 127
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/js/todolist.js"), "html", null, true);
        echo "\"></script>
    <!-- endinject -->
    </body>
    </html>

";
        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

    }

    public function getTemplateName()
    {
        return "registration/register.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  255 => 127,  251 => 126,  247 => 125,  243 => 124,  239 => 123,  231 => 118,  215 => 105,  211 => 104,  206 => 102,  196 => 95,  192 => 94,  186 => 91,  181 => 89,  173 => 84,  168 => 82,  160 => 77,  155 => 75,  147 => 70,  142 => 68,  134 => 63,  129 => 61,  121 => 56,  116 => 54,  107 => 48,  103 => 47,  75 => 22,  70 => 20,  60 => 13,  56 => 12,  43 => 1,);
    }

    public function getSourceContext()
    {
        return new Source("


    <!DOCTYPE html>
    <html lang=\"en\">
    <head>
        <!-- Required meta tags -->
        <meta charset=\"utf-8\">
        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
        <title>Corona Admin</title>
        <!-- plugins:css -->
        <link rel=\"stylesheet\" href=\"{{ asset('Back/assets/vendors/mdi/css/materialdesignicons.min.css') }}\">
        <link rel=\"stylesheet\" href=\"{{ asset('Back/assets/vendors/css/vendor.bundle.base.css') }}\">
        <!-- endinject -->
        <!-- Plugin css for this page -->
        <!-- End plugin css for this page -->
        <!-- inject:css -->
        <!-- endinject -->
        <!-- Layout styles -->
        <link rel=\"stylesheet\" href=\"{{ asset('Back/assets/css/style.css') }}\">
        <!-- End layout styles -->
        <link rel=\"shortcut icon\" href=\"{{ asset('Back/assets/images/favicon.png') }}\" />

        <style>
            #registration_form_agreeTerms{
                margin-top: -16px;
            }

            ul{
                background-color: #ff2828;
                border-radius: 9px;
            }
            .card{
                border: 2px solid white;
            }
        </style>
    </head>
    <body>
    <div class=\"container-scroller\">
        <div class=\"container-fluid page-body-wrapper full-page-wrapper\">
            <div class=\"row w-100 m-0\">
                <div class=\"content-wrapper full-page-wrapper d-flex align-items-center auth login-bg\">
                    <div class=\"card col-lg-4 mx-auto\">
                        <div class=\"card-body px-5 py-5\">
                            <h3 class=\"card-title text-center mb-3\">Sign up</h3>

                            {{ form_start(registrationForm , {'attr' : {'novalidate' : 'novalidate'}}) }}
                            {{ form_errors(registrationForm.firstname  , {'attr' : {'class' : ' alert alert-danger label'}}) }}
                            <div class=\"input-group input-group-merge input-group-alternative mb-3\">

                                <div class=\"input-group-prepend\">
                                    <span class=\"input-group-text\"><i class=\"mdi mdi-account\"></i></span>
                                </div>
                                {{ form_widget(registrationForm.firstname  , {'attr' : {'class' : 'form-control p_input' , 'placeholder' : 'first name'}}) }}
                            </div>
                            {{ form_errors(registrationForm.lastname  , {'attr' : {'class' : 'label' }}) }}
                            <div class=\"input-group input-group-merge input-group-alternative mb-3\">
                                <div class=\"input-group-prepend\">
                                    <span class=\"input-group-text\"><i class=\"mdi mdi-account\"></i></span>
                                </div>
                                {{ form_widget(registrationForm.lastname  , {'attr' : {'class' : 'form-control p_input' , 'placeholder' : 'last name'}}) }}
                            </div>
                            {{ form_errors(registrationForm.email  , {'attr' : {'class' : 'label' }}) }}
                            <div class=\"input-group input-group-merge input-group-alternative mb-3\">
                                <div class=\"input-group-prepend\">
                                    <span class=\"input-group-text\"><i class=\"mdi mdi-email\"></i></span>
                                </div>
                                {{ form_widget(registrationForm.email  , {'attr' : {'class' : 'form-control ' , 'placeholder' : 'email'}}) }}
                            </div>
                            {{ form_errors(registrationForm.plainPassword  , {'attr' : {'class' : 'label' }}) }}
                            <div class=\"input-group input-group-merge input-group-alternative mb-3\">
                                <div class=\"input-group-prepend\">
                                    <span class=\"input-group-text\"><i class=\"mdi mdi-lock\"></i></span>
                                </div>
                                {{ form_widget(registrationForm.plainPassword  , {'attr' : {'class' : 'form-control' , 'placeholder' : 'Password','novalidate' : 'novalidate'}}) }}
                            </div>
                            {{ form_errors(registrationForm.phone_number  , {'attr' : {'class' : 'label'}}) }}
                            <div class=\"input-group input-group-merge input-group-alternative mb-3\">
                                <div class=\"input-group-prepend\">
                                    <span class=\"input-group-text\"><i class=\"mdi mdi-cellphone\"></i></span>
                                </div>
                                {{ form_widget(registrationForm.phone_number  , {'attr' : {'class' : 'form-control' , 'placeholder' : 'Phone Number'}}) }}
                            </div>
                            {{ form_errors(registrationForm.usertag  , {'attr' : {'class' : 'label' }}) }}
                            <div class=\"input-group input-group-merge input-group-alternative mb-3\">
                                <div class=\"input-group-prepend\">
                                    <span class=\"input-group-text\"><i class=\"mdi mdi-cellphone\"></i></span>
                                </div>
                                {{ form_widget(registrationForm.usertag  , {'attr' : {'class' : 'form-control' , 'placeholder' : 'Username'}}) }}
                            </div>
                            {{ form_errors(registrationForm.agreeTerms  , {'attr' : {'class' : 'label'}}) }}
                            <div class=\"form-group d-flex align-items-center justify-content-between\">
                                <div class=\"form-check\">
                                    {{ form_label(registrationForm.agreeTerms, 'Agree to the terms and services' , {'label_attr' : {'class' : 'form-check-label'}}) }}
                                    {{ form_widget(registrationForm.agreeTerms  , {'attr' : {'class' : 'form-check-input'}} ) }}
                                </div>
                            </div>

                            <div class=\"text-center\">
                                <button type=\"submit\" class=\"btn btn-primary btn-block enter-btn\">Sign up</button>
                            </div>
                            {{ form_end(registrationForm) }}
                            <div class=\"form-group d-flex align-items-center justify-content-between\">
                                <a href=\"{{ path('app_login') }}\" class=\"forgot-pass\"><small>Login</small></a>
                                <a href=\"{{ path('app_forgotten_password') }}\" class=\"forgot-pass\"><small>Forgot password?</small></a>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- content-wrapper ends -->
            </div>
            <!-- row ends -->
        </div>
        <!-- page-body-wrapper ends -->
    </div>
    <!-- container-scroller -->
    <!-- plugins:js -->
    <script src=\"{{ asset('Back/assets/vendors/js/vendor.bundle.base.js') }}\"></script>
    <!-- endinject -->
    <!-- Plugin js for this page -->
    <!-- End plugin js for this page -->
    <!-- inject:js -->
    <script src=\"{{ asset('Back/assets/js/off-canvas.js') }}\"></script>
    <script src=\"{{ asset('Back/assets/js/hoverable-collapse.js') }}\"></script>
    <script src=\"{{ asset('Back/assets/js/misc.js') }}\"></script>
    <script src=\"{{ asset('Back/assets/js/settings.js') }}\"></script>
    <script src=\"{{ asset('Back/assets/js/todolist.js') }}\"></script>
    <!-- endinject -->
    </body>
    </html>

", "registration/register.html.twig", "C:\\Users\\Yassine\\Desktop\\git-login-symfony\\templates\\registration\\register.html.twig");
    }
}
