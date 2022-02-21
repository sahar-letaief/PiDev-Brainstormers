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
class __TwigTemplate_8f601ac2471225068c36cb1dac91278d8a480c002e4591c6db462b1d9580eec1 extends Template
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
        // line 39
        $context['_parent'] = $context;
        $context['_seq'] = twig_ensure_traversable(twig_get_attribute($this->env, $this->source, (isset($context["app"]) || array_key_exists("app", $context) ? $context["app"] : (function () { throw new RuntimeError('Variable "app" does not exist.', 39, $this->source); })()), "flashes", [0 => "verify_email_error"], "method", false, false, false, 39));
        foreach ($context['_seq'] as $context["_key"] => $context["flash_error"]) {
            // line 40
            echo "                                <div class=\"alert alert-danger\" role=\"alert\">";
            echo twig_escape_filter($this->env, $context["flash_error"], "html", null, true);
            echo "</div>
                            ";
        }
        $_parent = $context['_parent'];
        unset($context['_seq'], $context['_iterated'], $context['_key'], $context['flash_error'], $context['_parent'], $context['loop']);
        $context = array_intersect_key($context, $_parent) + $_parent;
        // line 42
        echo "
                            ";
        // line 43
        echo         $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->renderBlock((isset($context["registrationForm"]) || array_key_exists("registrationForm", $context) ? $context["registrationForm"] : (function () { throw new RuntimeError('Variable "registrationForm" does not exist.', 43, $this->source); })()), 'form_start', ["attr" => ["novalidate" => "novalidate"]]);
        echo "
                            <div class=\"input-group input-group-merge input-group-alternative mb-3\">
                                <div class=\"input-group-prepend\">
                                    <span class=\"input-group-text\"><i class=\"mdi mdi-account\"></i></span>
                                </div>
                                ";
        // line 48
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["registrationForm"]) || array_key_exists("registrationForm", $context) ? $context["registrationForm"] : (function () { throw new RuntimeError('Variable "registrationForm" does not exist.', 48, $this->source); })()), "firstname", [], "any", false, false, false, 48), 'widget', ["attr" => ["class" => "form-control p_input", "placeholder" => "first name"]]);
        echo "
                            </div>
                            <div class=\"input-group input-group-merge input-group-alternative mb-3\">
                                <div class=\"input-group-prepend\">
                                    <span class=\"input-group-text\"><i class=\"mdi mdi-account\"></i></span>
                                </div>
                                ";
        // line 54
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["registrationForm"]) || array_key_exists("registrationForm", $context) ? $context["registrationForm"] : (function () { throw new RuntimeError('Variable "registrationForm" does not exist.', 54, $this->source); })()), "lastname", [], "any", false, false, false, 54), 'widget', ["attr" => ["class" => "form-control p_input", "placeholder" => "last name"]]);
        echo "
                            </div>
                            <div class=\"input-group input-group-merge input-group-alternative mb-3\">
                                <div class=\"input-group-prepend\">
                                    <span class=\"input-group-text\"><i class=\"mdi mdi-email\"></i></span>
                                </div>
                                ";
        // line 60
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["registrationForm"]) || array_key_exists("registrationForm", $context) ? $context["registrationForm"] : (function () { throw new RuntimeError('Variable "registrationForm" does not exist.', 60, $this->source); })()), "email", [], "any", false, false, false, 60), 'widget', ["attr" => ["class" => "form-control ", "placeholder" => "email"]]);
        echo "
                            </div>
                            <div class=\"input-group input-group-merge input-group-alternative mb-3\">
                                <div class=\"input-group-prepend\">
                                    <span class=\"input-group-text\"><i class=\"mdi mdi-lock\"></i></span>
                                </div>
                                ";
        // line 66
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["registrationForm"]) || array_key_exists("registrationForm", $context) ? $context["registrationForm"] : (function () { throw new RuntimeError('Variable "registrationForm" does not exist.', 66, $this->source); })()), "plainPassword", [], "any", false, false, false, 66), 'widget', ["attr" => ["class" => "form-control", "placeholder" => "Password"]]);
        echo "
                            </div>
                            <div class=\"input-group input-group-merge input-group-alternative mb-3\">
                                <div class=\"input-group-prepend\">
                                    <span class=\"input-group-text\"><i class=\"mdi mdi-cellphone\"></i></span>
                                </div>
                                ";
        // line 72
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["registrationForm"]) || array_key_exists("registrationForm", $context) ? $context["registrationForm"] : (function () { throw new RuntimeError('Variable "registrationForm" does not exist.', 72, $this->source); })()), "phone_number", [], "any", false, false, false, 72), 'widget', ["attr" => ["class" => "form-control", "placeholder" => "Phone Number"]]);
        echo "
                            </div>
                            <div class=\"input-group input-group-merge input-group-alternative mb-3\">
                                <div class=\"input-group-prepend\">
                                    <span class=\"input-group-text\"><i class=\"mdi mdi-cellphone\"></i></span>
                                </div>
                                ";
        // line 78
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["registrationForm"]) || array_key_exists("registrationForm", $context) ? $context["registrationForm"] : (function () { throw new RuntimeError('Variable "registrationForm" does not exist.', 78, $this->source); })()), "usertag", [], "any", false, false, false, 78), 'widget', ["attr" => ["class" => "form-control", "placeholder" => "Username"]]);
        echo "
                            </div>
                            <div class=\"form-group d-flex align-items-center justify-content-between\">
                                <div class=\"form-check\">
                                    ";
        // line 82
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["registrationForm"]) || array_key_exists("registrationForm", $context) ? $context["registrationForm"] : (function () { throw new RuntimeError('Variable "registrationForm" does not exist.', 82, $this->source); })()), "agreeTerms", [], "any", false, false, false, 82), 'label', ["label_attr" => ["class" => "form-check-label"], "label" => "Agree to the terms and services"]);
        echo "
                                    ";
        // line 83
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["registrationForm"]) || array_key_exists("registrationForm", $context) ? $context["registrationForm"] : (function () { throw new RuntimeError('Variable "registrationForm" does not exist.', 83, $this->source); })()), "agreeTerms", [], "any", false, false, false, 83), 'widget', ["attr" => ["class" => "form-check-input"]]);
        echo "
                                </div>
                            </div>

                            <div class=\"text-center\">
                                <button type=\"submit\" class=\"btn btn-primary btn-block enter-btn\">Sign up</button>
                            </div>
                            ";
        // line 90
        echo         $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->renderBlock((isset($context["registrationForm"]) || array_key_exists("registrationForm", $context) ? $context["registrationForm"] : (function () { throw new RuntimeError('Variable "registrationForm" does not exist.', 90, $this->source); })()), 'form_end');
        echo "
                            <div class=\"form-group d-flex align-items-center justify-content-between\">
                                <a href=\"";
        // line 92
        echo $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("app_login");
        echo "\" class=\"forgot-pass\"><small>Login</small></a>
                                <a href=\"app_forgotten_password\" class=\"forgot-pass\"><small>Forgot password?</small></a>
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
        // line 106
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/vendors/js/vendor.bundle.base.js"), "html", null, true);
        echo "\"></script>
    <!-- endinject -->
    <!-- Plugin js for this page -->
    <!-- End plugin js for this page -->
    <!-- inject:js -->
    <script src=\"";
        // line 111
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/js/off-canvas.js"), "html", null, true);
        echo "\"></script>
    <script src=\"";
        // line 112
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/js/hoverable-collapse.js"), "html", null, true);
        echo "\"></script>
    <script src=\"";
        // line 113
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/js/misc.js"), "html", null, true);
        echo "\"></script>
    <script src=\"";
        // line 114
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/js/settings.js"), "html", null, true);
        echo "\"></script>
    <script src=\"";
        // line 115
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
        return array (  231 => 115,  227 => 114,  223 => 113,  219 => 112,  215 => 111,  207 => 106,  190 => 92,  185 => 90,  175 => 83,  171 => 82,  164 => 78,  155 => 72,  146 => 66,  137 => 60,  128 => 54,  119 => 48,  111 => 43,  108 => 42,  99 => 40,  95 => 39,  75 => 22,  70 => 20,  60 => 13,  56 => 12,  43 => 1,);
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

                            {% for flash_error in app.flashes('verify_email_error') %}
                                <div class=\"alert alert-danger\" role=\"alert\">{{ flash_error }}</div>
                            {% endfor %}

                            {{ form_start(registrationForm , {'attr' : {'novalidate' : 'novalidate'}}) }}
                            <div class=\"input-group input-group-merge input-group-alternative mb-3\">
                                <div class=\"input-group-prepend\">
                                    <span class=\"input-group-text\"><i class=\"mdi mdi-account\"></i></span>
                                </div>
                                {{ form_widget(registrationForm.firstname  , {'attr' : {'class' : 'form-control p_input' , 'placeholder' : 'first name'}}) }}
                            </div>
                            <div class=\"input-group input-group-merge input-group-alternative mb-3\">
                                <div class=\"input-group-prepend\">
                                    <span class=\"input-group-text\"><i class=\"mdi mdi-account\"></i></span>
                                </div>
                                {{ form_widget(registrationForm.lastname  , {'attr' : {'class' : 'form-control p_input' , 'placeholder' : 'last name'}}) }}
                            </div>
                            <div class=\"input-group input-group-merge input-group-alternative mb-3\">
                                <div class=\"input-group-prepend\">
                                    <span class=\"input-group-text\"><i class=\"mdi mdi-email\"></i></span>
                                </div>
                                {{ form_widget(registrationForm.email  , {'attr' : {'class' : 'form-control ' , 'placeholder' : 'email'}}) }}
                            </div>
                            <div class=\"input-group input-group-merge input-group-alternative mb-3\">
                                <div class=\"input-group-prepend\">
                                    <span class=\"input-group-text\"><i class=\"mdi mdi-lock\"></i></span>
                                </div>
                                {{ form_widget(registrationForm.plainPassword  , {'attr' : {'class' : 'form-control' , 'placeholder' : 'Password'}}) }}
                            </div>
                            <div class=\"input-group input-group-merge input-group-alternative mb-3\">
                                <div class=\"input-group-prepend\">
                                    <span class=\"input-group-text\"><i class=\"mdi mdi-cellphone\"></i></span>
                                </div>
                                {{ form_widget(registrationForm.phone_number  , {'attr' : {'class' : 'form-control' , 'placeholder' : 'Phone Number'}}) }}
                            </div>
                            <div class=\"input-group input-group-merge input-group-alternative mb-3\">
                                <div class=\"input-group-prepend\">
                                    <span class=\"input-group-text\"><i class=\"mdi mdi-cellphone\"></i></span>
                                </div>
                                {{ form_widget(registrationForm.usertag  , {'attr' : {'class' : 'form-control' , 'placeholder' : 'Username'}}) }}
                            </div>
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
                                <a href=\"app_forgotten_password\" class=\"forgot-pass\"><small>Forgot password?</small></a>
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

", "registration/register.html.twig", "C:\\Users\\Yassine\\Desktop\\gamex_login\\templates\\registration\\register.html.twig");
    }
}
