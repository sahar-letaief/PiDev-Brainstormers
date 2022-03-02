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

/* security/login.html.twig */
class __TwigTemplate_f2ad5304b73f280867e707f5d822f09a273552a6ea4731727dcc98874182a7a0 extends Template
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
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "security/login.html.twig"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "security/login.html.twig"));

        // line 1
        echo "
    ";
        // line 19
        echo "    <!DOCTYPE html>
    <html lang=\"en\">
    <head>
        <!-- Required meta tags -->
        <meta charset=\"utf-8\">
        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
        <title>Corona Admin</title>
        <!-- plugins:css -->
        <link rel=\"stylesheet\" href=\"";
        // line 27
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/vendors/mdi/css/materialdesignicons.min.css"), "html", null, true);
        echo "\">
        <link rel=\"stylesheet\" href=\"";
        // line 28
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/vendors/css/vendor.bundle.base.css"), "html", null, true);
        echo "\">
        <!-- endinject -->
        <!-- Plugin css for this page -->
        <!-- End plugin css for this page -->
        <!-- inject:css -->
        <!-- endinject -->
        <!-- Layout styles -->
        <link rel=\"stylesheet\" href=\"";
        // line 35
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/css/style.css"), "html", null, true);
        echo "\">
        <!-- End layout styles -->
        <link rel=\"shortcut icon\" href=\"";
        // line 37
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/images/favicon.png"), "html", null, true);
        echo "\" />
    </head>
    <body>
    <div class=\"container-scroller\">
        <div class=\"container-fluid page-body-wrapper full-page-wrapper\">
            <div class=\"row w-100 m-0\">
                <div class=\"content-wrapper full-page-wrapper d-flex align-items-center auth login-bg\">
                    <div class=\"card col-lg-4 mx-auto\">
                        <div class=\"card-body px-5 py-5\">
                            <h3 class=\"card-title text-left mb-3\">Login</h3>

                            ";
        // line 48
        if ((isset($context["error"]) || array_key_exists("error", $context) ? $context["error"] : (function () { throw new RuntimeError('Variable "error" does not exist.', 48, $this->source); })())) {
            // line 49
            echo "                                <div class=\"alert alert-danger\">";
            echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\TranslationExtension']->trans(twig_get_attribute($this->env, $this->source, (isset($context["error"]) || array_key_exists("error", $context) ? $context["error"] : (function () { throw new RuntimeError('Variable "error" does not exist.', 49, $this->source); })()), "messageKey", [], "any", false, false, false, 49), twig_get_attribute($this->env, $this->source, (isset($context["error"]) || array_key_exists("error", $context) ? $context["error"] : (function () { throw new RuntimeError('Variable "error" does not exist.', 49, $this->source); })()), "messageData", [], "any", false, false, false, 49), "security"), "html", null, true);
            echo "</div>
                            ";
        }
        // line 51
        echo "
                            <form method=\"post\">
                                <div class=\"form-group\">
                                    <label>Username or email *</label>
                                    <input placeholder=\"Email\" type=\"email\" value=\"";
        // line 55
        echo twig_escape_filter($this->env, (isset($context["last_username"]) || array_key_exists("last_username", $context) ? $context["last_username"] : (function () { throw new RuntimeError('Variable "last_username" does not exist.', 55, $this->source); })()), "html", null, true);
        echo "\" name=\"email\" id=\"inputEmail\" class=\"form-control p_input\" autocomplete=\"email\" required autofocus>
                                </div>
                                <div class=\"form-group\">
                                    <label>Password *</label>
                                    <input placeholder=\"Password\" type=\"password\" name=\"password\" id=\"inputPassword\" class=\"form-control p_input\" autocomplete=\"current-password\" required>
                                    <input type=\"hidden\" name=\"_csrf_token\" value=\"";
        // line 60
        echo twig_escape_filter($this->env, $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->renderCsrfToken("authenticate"), "html", null, true);
        echo "\">
                                </div>
                                <div class=\"form-group d-flex align-items-center justify-content-between\">
                                    <div class=\"form-check\">
                                        <div class=\"checkbox mb-3\">
                                            <label>
                                                <input type=\"checkbox\" name=\"_remember_me\"> Remember me
                                            </label>
                                        </div>
                                    </div>
                                    <a href=\"";
        // line 70
        echo $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("app_forgotten_password");
        echo "\" class=\"forgot-pass\"><small>Forgot password?</small></a>
                                </div>
                                <div class=\"text-center\">
                                    <button type=\"submit\" class=\"btn btn-primary btn-block enter-btn\">Login</button>
                                </div>
                                <p class=\"sign-up\">Don't have an Account?<a href=\"";
        // line 75
        echo $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("app_register");
        echo "\"> Sign Up</a></p>
                            </form>
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
        // line 88
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/vendors/js/vendor.bundle.base.js"), "html", null, true);
        echo "\"></script>
    <!-- endinject -->
    <!-- Plugin js for this page -->
    <!-- End plugin js for this page -->
    <!-- inject:js -->
    <script src=\"";
        // line 93
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/js/off-canvas.js"), "html", null, true);
        echo "\"></script>
    <script src=\"";
        // line 94
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/js/hoverable-collapse.js"), "html", null, true);
        echo "\"></script>
    <script src=\"";
        // line 95
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/js/misc.js"), "html", null, true);
        echo "\"></script>
    <script src=\"";
        // line 96
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/js/settings.js"), "html", null, true);
        echo "\"></script>
    <script src=\"";
        // line 97
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
        return "security/login.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  172 => 97,  168 => 96,  164 => 95,  160 => 94,  156 => 93,  148 => 88,  132 => 75,  124 => 70,  111 => 60,  103 => 55,  97 => 51,  91 => 49,  89 => 48,  75 => 37,  70 => 35,  60 => 28,  56 => 27,  46 => 19,  43 => 1,);
    }

    public function getSourceContext()
    {
        return new Source("
    {#

    {% if app.user %}
   <div class=\"mb-3\">
       You are logged in as {{ app.user.username }}, <a href=\"{{ path('app_logout') }}\">Logout</a>
   </div>
{% endif %}

   Uncomment this section and add a remember_me option below your firewall to activate remember me functionality.
   See https://symfony.com/doc/current/security/remember_me.html

   <div class=\"checkbox mb-3\">
       <label>
           <input type=\"checkbox\" name=\"_remember_me\"> Remember me
       </label>
   </div>
    #}
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
    </head>
    <body>
    <div class=\"container-scroller\">
        <div class=\"container-fluid page-body-wrapper full-page-wrapper\">
            <div class=\"row w-100 m-0\">
                <div class=\"content-wrapper full-page-wrapper d-flex align-items-center auth login-bg\">
                    <div class=\"card col-lg-4 mx-auto\">
                        <div class=\"card-body px-5 py-5\">
                            <h3 class=\"card-title text-left mb-3\">Login</h3>

                            {% if error %}
                                <div class=\"alert alert-danger\">{{ error.messageKey|trans(error.messageData, 'security') }}</div>
                            {% endif %}

                            <form method=\"post\">
                                <div class=\"form-group\">
                                    <label>Username or email *</label>
                                    <input placeholder=\"Email\" type=\"email\" value=\"{{ last_username }}\" name=\"email\" id=\"inputEmail\" class=\"form-control p_input\" autocomplete=\"email\" required autofocus>
                                </div>
                                <div class=\"form-group\">
                                    <label>Password *</label>
                                    <input placeholder=\"Password\" type=\"password\" name=\"password\" id=\"inputPassword\" class=\"form-control p_input\" autocomplete=\"current-password\" required>
                                    <input type=\"hidden\" name=\"_csrf_token\" value=\"{{ csrf_token('authenticate') }}\">
                                </div>
                                <div class=\"form-group d-flex align-items-center justify-content-between\">
                                    <div class=\"form-check\">
                                        <div class=\"checkbox mb-3\">
                                            <label>
                                                <input type=\"checkbox\" name=\"_remember_me\"> Remember me
                                            </label>
                                        </div>
                                    </div>
                                    <a href=\"{{ path('app_forgotten_password') }}\" class=\"forgot-pass\"><small>Forgot password?</small></a>
                                </div>
                                <div class=\"text-center\">
                                    <button type=\"submit\" class=\"btn btn-primary btn-block enter-btn\">Login</button>
                                </div>
                                <p class=\"sign-up\">Don't have an Account?<a href=\"{{ path('app_register') }}\"> Sign Up</a></p>
                            </form>
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
", "security/login.html.twig", "C:\\Users\\Yassine\\Desktop\\git-login-symfony\\templates\\security\\login.html.twig");
    }
}
