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

/* baseBack.html.twig */
class __TwigTemplate_6727bcbd7f521af133819b4cb1f8e632233379f43e8ebe24cdb059ba6b26465a extends Template
{
    private $source;
    private $macros = [];

    public function __construct(Environment $env)
    {
        parent::__construct($env);

        $this->source = $this->getSourceContext();

        $this->parent = false;

        $this->blocks = [
            'stylesheets' => [$this, 'block_stylesheets'],
            'nav' => [$this, 'block_nav'],
            'body' => [$this, 'block_body'],
            'javascripts' => [$this, 'block_javascripts'],
        ];
    }

    protected function doDisplay(array $context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "baseBack.html.twig"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "baseBack.html.twig"));

        // line 1
        echo "<!DOCTYPE html>
<html>
<head>

    ";
        // line 5
        $this->displayBlock('stylesheets', $context, $blocks);
        // line 27
        echo "
</head>
<body>
";
        // line 30
        $this->displayBlock('nav', $context, $blocks);
        // line 314
        echo "
";
        // line 315
        $this->displayBlock('body', $context, $blocks);
        // line 318
        echo "</div>
</div>

<!-- container-scroller -->
</body>

";
        // line 324
        $this->displayBlock('javascripts', $context, $blocks);
        // line 349
        echo "

</html>
";
        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

    }

    // line 5
    public function block_stylesheets($context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "stylesheets"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "stylesheets"));

        // line 6
        echo "        <!-- Required meta tags -->
        <meta charset=\"utf-8\">
        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
        <title>GAMEX</title>
        <!-- plugins:css -->
        <link rel=\"stylesheet\" href=\"";
        // line 11
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/vendors/mdi/css/materialdesignicons.min.css"), "html", null, true);
        echo "\">
        <link rel=\"stylesheet\" href=\"";
        // line 12
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/vendors/css/vendor.bundle.base.css"), "html", null, true);
        echo "\">
        <!-- endinject -->
        <!-- Plugin css for this page -->
        <link rel=\"stylesheet\" href=\"";
        // line 15
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/vendors/jvectormap/jquery-jvectormap.css"), "html", null, true);
        echo "\">
        <link rel=\"stylesheet\" href=\"";
        // line 16
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/vendors/flag-icon-css/css/flag-icon.min.css"), "html", null, true);
        echo "\">
        <link rel=\"stylesheet\" href=\"";
        // line 17
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/vendors/owl-carousel-2/owl.carousel.min.css"), "html", null, true);
        echo "\">
        <link rel=\"stylesheet\" href=\"";
        // line 18
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/vendors/owl-carousel-2/owl.theme.default.min.css"), "html", null, true);
        echo "\">
        <!-- End plugin css for this page -->
        <!-- inject:css -->
        <!-- endinject -->
        <!-- Layout styles -->
        <link rel=\"stylesheet\" href=\"";
        // line 23
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/css/style.css"), "html", null, true);
        echo "\">
        <!-- End layout styles -->
        <link rel=\"shortcut icon\" href=\"";
        // line 25
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/images/favicon.png"), "html", null, true);
        echo "\" />
    ";
        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

    }

    // line 30
    public function block_nav($context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "nav"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "nav"));

        // line 31
        echo "
<div class=\"container-scroller\">
    <!-- partial:partials/_sidebar.html -->
    <nav class=\"sidebar sidebar-offcanvas\" id=\"sidebar\">
        <div class=\"sidebar-brand-wrapper d-none d-lg-flex align-items-center justify-content-center fixed-top\">
            <a class=\"sidebar-brand brand-logo\" href=\"index.html\"><img src=\"";
        // line 36
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/images/logo.svg"), "html", null, true);
        echo "\" alt=\"logo\" /></a>
            <a class=\"sidebar-brand brand-logo-mini\" href=\"index.html\"><img src=\"";
        // line 37
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/images/logo-mini.svg"), "html", null, true);
        echo "\" alt=\"logo\" /></a>
        </div>
        <ul class=\"nav\">
            <li class=\"nav-item profile\">
                <div class=\"profile-desc\">
                    <div class=\"profile-pic\">
                        <div class=\"count-indicator\">
                            <img class=\"img-xs rounded-circle \" src=\"";
        // line 44
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/images/faces/face15.jpg"), "html", null, true);
        echo "\" alt=\"\">
                            <span class=\"count bg-success\"></span>
                        </div>
                        <div class=\"profile-name\">
                            <h5 class=\"mb-0 font-weight-normal\">";
        // line 48
        echo twig_escape_filter($this->env, ((twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, (isset($context["app"]) || array_key_exists("app", $context) ? $context["app"] : (function () { throw new RuntimeError('Variable "app" does not exist.', 48, $this->source); })()), "user", [], "any", false, false, false, 48), "firstname", [], "any", false, false, false, 48) . " ") . twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, (isset($context["app"]) || array_key_exists("app", $context) ? $context["app"] : (function () { throw new RuntimeError('Variable "app" does not exist.', 48, $this->source); })()), "user", [], "any", false, false, false, 48), "lastname", [], "any", false, false, false, 48)), "html", null, true);
        echo "</h5>
                            ";
        // line 49
        if ($this->extensions['Symfony\Bridge\Twig\Extension\SecurityExtension']->isGranted("ROLE_ADMIN")) {
            // line 50
            echo "                            <span>ADMIN</span>
                            ";
        }
        // line 52
        echo "                        </div>
                    </div>
                    <a href=\"#\" id=\"profile-dropdown\" data-toggle=\"dropdown\"><i class=\"mdi mdi-dots-vertical\"></i></a>
                    <div class=\"dropdown-menu dropdown-menu-right sidebar-dropdown preview-list\" aria-labelledby=\"profile-dropdown\">
                        <a href=\"#\" class=\"dropdown-item preview-item\">
                            <div class=\"preview-thumbnail\">
                                <div class=\"preview-icon bg-dark rounded-circle\">
                                    <i class=\"mdi mdi-settings text-primary\"></i>
                                </div>
                            </div>
                            <div class=\"preview-item-content\">
                                <p class=\"preview-subject ellipsis mb-1 text-small\">Account settings</p>
                            </div>
                        </a>
                        <div class=\"dropdown-divider\"></div>
                        <a href=\"#\" class=\"dropdown-item preview-item\">
                            <div class=\"preview-thumbnail\">
                                <div class=\"preview-icon bg-dark rounded-circle\">
                                    <i class=\"mdi mdi-onepassword  text-info\"></i>
                                </div>
                            </div>
                            <div class=\"preview-item-content\">
                                <p class=\"preview-subject ellipsis mb-1 text-small\">Change Password</p>
                            </div>
                        </a>
                        <div class=\"dropdown-divider\"></div>
                        <a href=\"#\" class=\"dropdown-item preview-item\">
                            <div class=\"preview-thumbnail\">
                                <div class=\"preview-icon bg-dark rounded-circle\">
                                    <i class=\"mdi mdi-calendar-today text-success\"></i>
                                </div>
                            </div>
                            <div class=\"preview-item-content\">
                                <p class=\"preview-subject ellipsis mb-1 text-small\">To-do list</p>
                            </div>
                        </a>
                    </div>
                </div>
            </li>
            <li class=\"nav-item nav-category\">
                <span class=\"nav-link\">Navigation</span>
            </li>
            ";
        // line 94
        if ($this->extensions['Symfony\Bridge\Twig\Extension\SecurityExtension']->isGranted("ROLE_ADMIN")) {
            // line 95
            echo "                ";
            if ((0 === twig_compare($this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath(twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, (isset($context["app"]) || array_key_exists("app", $context) ? $context["app"] : (function () { throw new RuntimeError('Variable "app" does not exist.', 95, $this->source); })()), "request", [], "any", false, false, false, 95), "attributes", [], "any", false, false, false, 95), "get", [0 => "_route"], "method", false, false, false, 95), twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, (isset($context["app"]) || array_key_exists("app", $context) ? $context["app"] : (function () { throw new RuntimeError('Variable "app" does not exist.', 95, $this->source); })()), "request", [], "any", false, false, false, 95), "attributes", [], "any", false, false, false, 95), "get", [0 => "_route_params"], "method", false, false, false, 95)), "/user/"))) {
                // line 96
                echo "                    <li class=\"nav-item menu-items active\">
                        <a class=\"nav-link\" href=\"";
                // line 97
                echo $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("user_index");
                echo "\">
              <span class=\"menu-icon\">
                <i class=\"mdi mdi-speedometer\"></i>
              </span>
                            <span class=\"menu-title\">Users</span>
                        </a>
                    </li>
                ";
            } else {
                // line 105
                echo "                    <li class=\"nav-item menu-items\">
                        <a class=\"nav-link\" href=\"";
                // line 106
                echo $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("user_index");
                echo "\">
              <span class=\"menu-icon\">
                <i class=\"mdi mdi-speedometer\"></i>
              </span>
                            <span class=\"menu-title\">Users</span>
                        </a>
                    </li>
                ";
            }
            // line 114
            echo "            ";
        }
        // line 115
        echo "
        </ul>
    </nav>

    <div class=\"container-fluid page-body-wrapper\">
        <!-- partial:partials/_navbar.html -->
        <nav class=\"navbar p-0 fixed-top d-flex flex-row\">
            <div class=\"navbar-brand-wrapper d-flex d-lg-none align-items-center justify-content-center\">
                <a class=\"navbar-brand brand-logo-mini\" href=\"index.html\"><img src=\"";
        // line 123
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/images/logo-mini.svg"), "html", null, true);
        echo "\" alt=\"logo\" /></a>
            </div>
            <div class=\"navbar-menu-wrapper flex-grow d-flex align-items-stretch\">
                <button class=\"navbar-toggler navbar-toggler align-self-center\" type=\"button\" data-toggle=\"minimize\">
                    <span class=\"mdi mdi-menu\"></span>
                </button>
                <ul class=\"navbar-nav w-100\">
                    <li class=\"nav-item w-100\">
                        <form class=\"nav-link mt-2 mt-md-0 d-none d-lg-flex search\">
                            <input type=\"text\" class=\"form-control\" placeholder=\"Search products\">
                        </form>
                    </li>
                </ul>
                <ul class=\"navbar-nav navbar-nav-right\">
                    <li class=\"nav-item dropdown d-none d-lg-block\">
                        <a class=\"nav-link btn btn-success create-new-button\" id=\"createbuttonDropdown\" data-toggle=\"dropdown\" aria-expanded=\"false\" href=\"#\">+ Create New Project</a>
                        <div class=\"dropdown-menu dropdown-menu-right navbar-dropdown preview-list\" aria-labelledby=\"createbuttonDropdown\">
                            <h6 class=\"p-3 mb-0\">Projects</h6>
                            <div class=\"dropdown-divider\"></div>
                            <a class=\"dropdown-item preview-item\">
                                <div class=\"preview-thumbnail\">
                                    <div class=\"preview-icon bg-dark rounded-circle\">
                                        <i class=\"mdi mdi-file-outline text-primary\"></i>
                                    </div>
                                </div>
                                <div class=\"preview-item-content\">
                                    <p class=\"preview-subject ellipsis mb-1\">Software Development</p>
                                </div>
                            </a>
                            <div class=\"dropdown-divider\"></div>
                            <a class=\"dropdown-item preview-item\">
                                <div class=\"preview-thumbnail\">
                                    <div class=\"preview-icon bg-dark rounded-circle\">
                                        <i class=\"mdi mdi-web text-info\"></i>
                                    </div>
                                </div>
                                <div class=\"preview-item-content\">
                                    <p class=\"preview-subject ellipsis mb-1\">UI Development</p>
                                </div>
                            </a>
                            <div class=\"dropdown-divider\"></div>
                            <a class=\"dropdown-item preview-item\">
                                <div class=\"preview-thumbnail\">
                                    <div class=\"preview-icon bg-dark rounded-circle\">
                                        <i class=\"mdi mdi-layers text-danger\"></i>
                                    </div>
                                </div>
                                <div class=\"preview-item-content\">
                                    <p class=\"preview-subject ellipsis mb-1\">Software Testing</p>
                                </div>
                            </a>
                            <div class=\"dropdown-divider\"></div>
                            <p class=\"p-3 mb-0 text-center\">See all projects</p>
                        </div>
                    </li>
                    <li class=\"nav-item nav-settings d-none d-lg-block\">
                        <a class=\"nav-link\" href=\"#\">
                            <i class=\"mdi mdi-view-grid\"></i>
                        </a>
                    </li>
                    <li class=\"nav-item dropdown border-left\">
                        <a class=\"nav-link count-indicator dropdown-toggle\" id=\"messageDropdown\" href=\"#\" data-toggle=\"dropdown\" aria-expanded=\"false\">
                            <i class=\"mdi mdi-email\"></i>
                            <span class=\"count bg-success\"></span>
                        </a>
                        <div class=\"dropdown-menu dropdown-menu-right navbar-dropdown preview-list\" aria-labelledby=\"messageDropdown\">
                            <h6 class=\"p-3 mb-0\">Messages</h6>
                            <div class=\"dropdown-divider\"></div>
                            <a class=\"dropdown-item preview-item\">
                                <div class=\"preview-thumbnail\">
                                    <img src=\"";
        // line 193
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/images/faces/face4.jpg"), "html", null, true);
        echo "\" alt=\"image\" class=\"rounded-circle profile-pic\">
                                </div>
                                <div class=\"preview-item-content\">
                                    <p class=\"preview-subject ellipsis mb-1\">Mark send you a message</p>
                                    <p class=\"text-muted mb-0\"> 1 Minutes ago </p>
                                </div>
                            </a>
                            <div class=\"dropdown-divider\"></div>
                            <a class=\"dropdown-item preview-item\">
                                <div class=\"preview-thumbnail\">
                                    <img src=\"";
        // line 203
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/images/faces/face2.jpg"), "html", null, true);
        echo "\" alt=\"image\" class=\"rounded-circle profile-pic\">
                                </div>
                                <div class=\"preview-item-content\">
                                    <p class=\"preview-subject ellipsis mb-1\">Cregh send you a message</p>
                                    <p class=\"text-muted mb-0\"> 15 Minutes ago </p>
                                </div>
                            </a>
                            <div class=\"dropdown-divider\"></div>
                            <a class=\"dropdown-item preview-item\">
                                <div class=\"preview-thumbnail\">
                                    <img src=\"";
        // line 213
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/images/faces/face3.jpg"), "html", null, true);
        echo "\" alt=\"image\" class=\"rounded-circle profile-pic\">
                                </div>
                                <div class=\"preview-item-content\">
                                    <p class=\"preview-subject ellipsis mb-1\">Profile picture updated</p>
                                    <p class=\"text-muted mb-0\"> 18 Minutes ago </p>
                                </div>
                            </a>
                            <div class=\"dropdown-divider\"></div>
                            <p class=\"p-3 mb-0 text-center\">4 new messages</p>
                        </div>
                    </li>
                    <li class=\"nav-item dropdown border-left\">
                        <a class=\"nav-link count-indicator dropdown-toggle\" id=\"notificationDropdown\" href=\"#\" data-toggle=\"dropdown\">
                            <i class=\"mdi mdi-bell\"></i>
                            <span class=\"count bg-danger\"></span>
                        </a>
                        <div class=\"dropdown-menu dropdown-menu-right navbar-dropdown preview-list\" aria-labelledby=\"notificationDropdown\">
                            <h6 class=\"p-3 mb-0\">Notifications</h6>
                            <div class=\"dropdown-divider\"></div>
                            <a class=\"dropdown-item preview-item\">
                                <div class=\"preview-thumbnail\">
                                    <div class=\"preview-icon bg-dark rounded-circle\">
                                        <i class=\"mdi mdi-calendar text-success\"></i>
                                    </div>
                                </div>
                                <div class=\"preview-item-content\">
                                    <p class=\"preview-subject mb-1\">Event today</p>
                                    <p class=\"text-muted ellipsis mb-0\"> Just a reminder that you have an event today </p>
                                </div>
                            </a>
                            <div class=\"dropdown-divider\"></div>
                            <a class=\"dropdown-item preview-item\">
                                <div class=\"preview-thumbnail\">
                                    <div class=\"preview-icon bg-dark rounded-circle\">
                                        <i class=\"mdi mdi-settings text-danger\"></i>
                                    </div>
                                </div>
                                <div class=\"preview-item-content\">
                                    <p class=\"preview-subject mb-1\">Settings</p>
                                    <p class=\"text-muted ellipsis mb-0\"> Update dashboard </p>
                                </div>
                            </a>
                            <div class=\"dropdown-divider\"></div>
                            <a class=\"dropdown-item preview-item\">
                                <div class=\"preview-thumbnail\">
                                    <div class=\"preview-icon bg-dark rounded-circle\">
                                        <i class=\"mdi mdi-link-variant text-warning\"></i>
                                    </div>
                                </div>
                                <div class=\"preview-item-content\">
                                    <p class=\"preview-subject mb-1\">Launch Admin</p>
                                    <p class=\"text-muted ellipsis mb-0\"> New admin wow! </p>
                                </div>
                            </a>
                            <div class=\"dropdown-divider\"></div>
                            <p class=\"p-3 mb-0 text-center\">See all notifications</p>
                        </div>
                    </li>
                    <li class=\"nav-item dropdown\">
                        <a class=\"nav-link\" id=\"profileDropdown\" href=\"#\" data-toggle=\"dropdown\">
                            <div class=\"navbar-profile\">
                                <img class=\"img-xs rounded-circle\" src=\"";
        // line 274
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/images/faces/face15.jpg"), "html", null, true);
        echo "\" alt=\"\">
                                <p class=\"mb-0 d-none d-sm-block navbar-profile-name\">";
        // line 275
        echo twig_escape_filter($this->env, ((twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, (isset($context["app"]) || array_key_exists("app", $context) ? $context["app"] : (function () { throw new RuntimeError('Variable "app" does not exist.', 275, $this->source); })()), "user", [], "any", false, false, false, 275), "firstname", [], "any", false, false, false, 275) . " ") . twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, (isset($context["app"]) || array_key_exists("app", $context) ? $context["app"] : (function () { throw new RuntimeError('Variable "app" does not exist.', 275, $this->source); })()), "user", [], "any", false, false, false, 275), "lastname", [], "any", false, false, false, 275)), "html", null, true);
        echo "</p>
                                <i class=\"mdi mdi-menu-down d-none d-sm-block\"></i>
                            </div>
                        </a>
                        <div class=\"dropdown-menu dropdown-menu-right navbar-dropdown preview-list\" aria-labelledby=\"profileDropdown\">
                            <h6 class=\"p-3 mb-0\">Profile</h6>
                            <div class=\"dropdown-divider\"></div>
                            <a class=\"dropdown-item preview-item\">
                                <div class=\"preview-thumbnail\">
                                    <div class=\"preview-icon bg-dark rounded-circle\">
                                        <i class=\"mdi mdi-settings text-success\"></i>
                                    </div>
                                </div>
                                <div class=\"preview-item-content\">
                                    <p class=\"preview-subject mb-1\">Settings</p>
                                </div>
                            </a>
                            <div class=\"dropdown-divider\"></div>
                            <a href=\"";
        // line 293
        echo $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("app_logout");
        echo "\" class=\"dropdown-item preview-item\">
                                <div class=\"preview-thumbnail\">
                                    <div class=\"preview-icon bg-dark rounded-circle\">
                                        <i class=\"mdi mdi-logout text-danger\"></i>
                                    </div>
                                </div>
                                <div class=\"preview-item-content\">
                                    <p class=\"preview-subject mb-1\">Log Out</p>
                                </div>
                            </a>
                            <div class=\"dropdown-divider\"></div>
                            <p class=\"p-3 mb-0 text-center\">Advanced settings</p>
                        </div>
                    </li>
                </ul>
                <button class=\"navbar-toggler navbar-toggler-right d-lg-none align-self-center\" type=\"button\" data-toggle=\"offcanvas\">
                    <span class=\"mdi mdi-format-line-spacing\"></span>
                </button>
            </div>
        </nav>
";
        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

    }

    // line 315
    public function block_body($context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "body"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "body"));

        // line 316
        echo "
";
        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

    }

    // line 324
    public function block_javascripts($context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "javascripts"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "javascripts"));

        // line 325
        echo "
    <!-- container-scroller -->
    <!-- plugins:js -->
    <script src=\"";
        // line 328
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/vendors/js/vendor.bundle.base.js"), "html", null, true);
        echo "\"></script>
    <!-- endinject -->
    <!-- Plugin js for this page -->
    <script src=\"";
        // line 331
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/vendors/chart.js/Chart.min.js"), "html", null, true);
        echo "\"></script>
    <script src=\"";
        // line 332
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/vendors/progressbar.js/progressbar.min.js"), "html", null, true);
        echo "\"></script>
    <script src=\"";
        // line 333
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/vendors/jvectormap/jquery-jvectormap.min.js"), "html", null, true);
        echo "\"></script>
    <script src=\"";
        // line 334
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/vendors/jvectormap/jquery-jvectormap-world-mill-en.js"), "html", null, true);
        echo "\"></script>
    <script src=\"";
        // line 335
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/vendors/owl-carousel-2/owl.carousel.min.js"), "html", null, true);
        echo "\"></script>
    <!-- End plugin js for this page -->
    <!-- inject:js -->
    <script src=\"";
        // line 338
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/js/off-canvas.js"), "html", null, true);
        echo "\"></script>
    <script src=\"";
        // line 339
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/js/hoverable-collapse.js"), "html", null, true);
        echo "\"></script>
    <script src=\"";
        // line 340
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/js/misc.js"), "html", null, true);
        echo "\"></script>
    <script src=\"";
        // line 341
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/js/settings.js"), "html", null, true);
        echo "\"></script>
    <script src=\"";
        // line 342
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/js/todolist.js"), "html", null, true);
        echo "\"></script>
    <!-- endinject -->
    <!-- Custom js for this page -->
    <script src=\"";
        // line 345
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/js/dashboard.js"), "html", null, true);
        echo "\"></script>
    <!-- End custom js for this page -->

";
        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

    }

    public function getTemplateName()
    {
        return "baseBack.html.twig";
    }

    public function getDebugInfo()
    {
        return array (  597 => 345,  591 => 342,  587 => 341,  583 => 340,  579 => 339,  575 => 338,  569 => 335,  565 => 334,  561 => 333,  557 => 332,  553 => 331,  547 => 328,  542 => 325,  532 => 324,  521 => 316,  511 => 315,  480 => 293,  459 => 275,  455 => 274,  391 => 213,  378 => 203,  365 => 193,  292 => 123,  282 => 115,  279 => 114,  268 => 106,  265 => 105,  254 => 97,  251 => 96,  248 => 95,  246 => 94,  202 => 52,  198 => 50,  196 => 49,  192 => 48,  185 => 44,  175 => 37,  171 => 36,  164 => 31,  154 => 30,  142 => 25,  137 => 23,  129 => 18,  125 => 17,  121 => 16,  117 => 15,  111 => 12,  107 => 11,  100 => 6,  90 => 5,  77 => 349,  75 => 324,  67 => 318,  65 => 315,  62 => 314,  60 => 30,  55 => 27,  53 => 5,  47 => 1,);
    }

    public function getSourceContext()
    {
        return new Source("<!DOCTYPE html>
<html>
<head>

    {% block stylesheets %}
        <!-- Required meta tags -->
        <meta charset=\"utf-8\">
        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
        <title>GAMEX</title>
        <!-- plugins:css -->
        <link rel=\"stylesheet\" href=\"{{ asset('Back/assets/vendors/mdi/css/materialdesignicons.min.css') }}\">
        <link rel=\"stylesheet\" href=\"{{ asset('Back/assets/vendors/css/vendor.bundle.base.css') }}\">
        <!-- endinject -->
        <!-- Plugin css for this page -->
        <link rel=\"stylesheet\" href=\"{{ asset('Back/assets/vendors/jvectormap/jquery-jvectormap.css') }}\">
        <link rel=\"stylesheet\" href=\"{{ asset('Back/assets/vendors/flag-icon-css/css/flag-icon.min.css') }}\">
        <link rel=\"stylesheet\" href=\"{{ asset('Back/assets/vendors/owl-carousel-2/owl.carousel.min.css') }}\">
        <link rel=\"stylesheet\" href=\"{{ asset('Back/assets/vendors/owl-carousel-2/owl.theme.default.min.css') }}\">
        <!-- End plugin css for this page -->
        <!-- inject:css -->
        <!-- endinject -->
        <!-- Layout styles -->
        <link rel=\"stylesheet\" href=\"{{ asset('Back/assets/css/style.css') }}\">
        <!-- End layout styles -->
        <link rel=\"shortcut icon\" href=\"{{ asset('Back/assets/images/favicon.png') }}\" />
    {% endblock %}

</head>
<body>
{% block nav %}

<div class=\"container-scroller\">
    <!-- partial:partials/_sidebar.html -->
    <nav class=\"sidebar sidebar-offcanvas\" id=\"sidebar\">
        <div class=\"sidebar-brand-wrapper d-none d-lg-flex align-items-center justify-content-center fixed-top\">
            <a class=\"sidebar-brand brand-logo\" href=\"index.html\"><img src=\"{{ asset('Back/assets/images/logo.svg') }}\" alt=\"logo\" /></a>
            <a class=\"sidebar-brand brand-logo-mini\" href=\"index.html\"><img src=\"{{ asset('Back/assets/images/logo-mini.svg') }}\" alt=\"logo\" /></a>
        </div>
        <ul class=\"nav\">
            <li class=\"nav-item profile\">
                <div class=\"profile-desc\">
                    <div class=\"profile-pic\">
                        <div class=\"count-indicator\">
                            <img class=\"img-xs rounded-circle \" src=\"{{ asset('Back/assets/images/faces/face15.jpg') }}\" alt=\"\">
                            <span class=\"count bg-success\"></span>
                        </div>
                        <div class=\"profile-name\">
                            <h5 class=\"mb-0 font-weight-normal\">{{ app.user.firstname ~ \" \" ~ app.user.lastname }}</h5>
                            {% if is_granted('ROLE_ADMIN') %}
                            <span>ADMIN</span>
                            {% endif %}
                        </div>
                    </div>
                    <a href=\"#\" id=\"profile-dropdown\" data-toggle=\"dropdown\"><i class=\"mdi mdi-dots-vertical\"></i></a>
                    <div class=\"dropdown-menu dropdown-menu-right sidebar-dropdown preview-list\" aria-labelledby=\"profile-dropdown\">
                        <a href=\"#\" class=\"dropdown-item preview-item\">
                            <div class=\"preview-thumbnail\">
                                <div class=\"preview-icon bg-dark rounded-circle\">
                                    <i class=\"mdi mdi-settings text-primary\"></i>
                                </div>
                            </div>
                            <div class=\"preview-item-content\">
                                <p class=\"preview-subject ellipsis mb-1 text-small\">Account settings</p>
                            </div>
                        </a>
                        <div class=\"dropdown-divider\"></div>
                        <a href=\"#\" class=\"dropdown-item preview-item\">
                            <div class=\"preview-thumbnail\">
                                <div class=\"preview-icon bg-dark rounded-circle\">
                                    <i class=\"mdi mdi-onepassword  text-info\"></i>
                                </div>
                            </div>
                            <div class=\"preview-item-content\">
                                <p class=\"preview-subject ellipsis mb-1 text-small\">Change Password</p>
                            </div>
                        </a>
                        <div class=\"dropdown-divider\"></div>
                        <a href=\"#\" class=\"dropdown-item preview-item\">
                            <div class=\"preview-thumbnail\">
                                <div class=\"preview-icon bg-dark rounded-circle\">
                                    <i class=\"mdi mdi-calendar-today text-success\"></i>
                                </div>
                            </div>
                            <div class=\"preview-item-content\">
                                <p class=\"preview-subject ellipsis mb-1 text-small\">To-do list</p>
                            </div>
                        </a>
                    </div>
                </div>
            </li>
            <li class=\"nav-item nav-category\">
                <span class=\"nav-link\">Navigation</span>
            </li>
            {% if is_granted('ROLE_ADMIN') %}
                {% if path(app.request.attributes.get('_route'),app.request.attributes.get('_route_params')) == '/user/' %}
                    <li class=\"nav-item menu-items active\">
                        <a class=\"nav-link\" href=\"{{ path('user_index') }}\">
              <span class=\"menu-icon\">
                <i class=\"mdi mdi-speedometer\"></i>
              </span>
                            <span class=\"menu-title\">Users</span>
                        </a>
                    </li>
                {% else %}
                    <li class=\"nav-item menu-items\">
                        <a class=\"nav-link\" href=\"{{ path('user_index') }}\">
              <span class=\"menu-icon\">
                <i class=\"mdi mdi-speedometer\"></i>
              </span>
                            <span class=\"menu-title\">Users</span>
                        </a>
                    </li>
                {% endif %}
            {% endif %}

        </ul>
    </nav>

    <div class=\"container-fluid page-body-wrapper\">
        <!-- partial:partials/_navbar.html -->
        <nav class=\"navbar p-0 fixed-top d-flex flex-row\">
            <div class=\"navbar-brand-wrapper d-flex d-lg-none align-items-center justify-content-center\">
                <a class=\"navbar-brand brand-logo-mini\" href=\"index.html\"><img src=\"{{ asset('Back/assets/images/logo-mini.svg') }}\" alt=\"logo\" /></a>
            </div>
            <div class=\"navbar-menu-wrapper flex-grow d-flex align-items-stretch\">
                <button class=\"navbar-toggler navbar-toggler align-self-center\" type=\"button\" data-toggle=\"minimize\">
                    <span class=\"mdi mdi-menu\"></span>
                </button>
                <ul class=\"navbar-nav w-100\">
                    <li class=\"nav-item w-100\">
                        <form class=\"nav-link mt-2 mt-md-0 d-none d-lg-flex search\">
                            <input type=\"text\" class=\"form-control\" placeholder=\"Search products\">
                        </form>
                    </li>
                </ul>
                <ul class=\"navbar-nav navbar-nav-right\">
                    <li class=\"nav-item dropdown d-none d-lg-block\">
                        <a class=\"nav-link btn btn-success create-new-button\" id=\"createbuttonDropdown\" data-toggle=\"dropdown\" aria-expanded=\"false\" href=\"#\">+ Create New Project</a>
                        <div class=\"dropdown-menu dropdown-menu-right navbar-dropdown preview-list\" aria-labelledby=\"createbuttonDropdown\">
                            <h6 class=\"p-3 mb-0\">Projects</h6>
                            <div class=\"dropdown-divider\"></div>
                            <a class=\"dropdown-item preview-item\">
                                <div class=\"preview-thumbnail\">
                                    <div class=\"preview-icon bg-dark rounded-circle\">
                                        <i class=\"mdi mdi-file-outline text-primary\"></i>
                                    </div>
                                </div>
                                <div class=\"preview-item-content\">
                                    <p class=\"preview-subject ellipsis mb-1\">Software Development</p>
                                </div>
                            </a>
                            <div class=\"dropdown-divider\"></div>
                            <a class=\"dropdown-item preview-item\">
                                <div class=\"preview-thumbnail\">
                                    <div class=\"preview-icon bg-dark rounded-circle\">
                                        <i class=\"mdi mdi-web text-info\"></i>
                                    </div>
                                </div>
                                <div class=\"preview-item-content\">
                                    <p class=\"preview-subject ellipsis mb-1\">UI Development</p>
                                </div>
                            </a>
                            <div class=\"dropdown-divider\"></div>
                            <a class=\"dropdown-item preview-item\">
                                <div class=\"preview-thumbnail\">
                                    <div class=\"preview-icon bg-dark rounded-circle\">
                                        <i class=\"mdi mdi-layers text-danger\"></i>
                                    </div>
                                </div>
                                <div class=\"preview-item-content\">
                                    <p class=\"preview-subject ellipsis mb-1\">Software Testing</p>
                                </div>
                            </a>
                            <div class=\"dropdown-divider\"></div>
                            <p class=\"p-3 mb-0 text-center\">See all projects</p>
                        </div>
                    </li>
                    <li class=\"nav-item nav-settings d-none d-lg-block\">
                        <a class=\"nav-link\" href=\"#\">
                            <i class=\"mdi mdi-view-grid\"></i>
                        </a>
                    </li>
                    <li class=\"nav-item dropdown border-left\">
                        <a class=\"nav-link count-indicator dropdown-toggle\" id=\"messageDropdown\" href=\"#\" data-toggle=\"dropdown\" aria-expanded=\"false\">
                            <i class=\"mdi mdi-email\"></i>
                            <span class=\"count bg-success\"></span>
                        </a>
                        <div class=\"dropdown-menu dropdown-menu-right navbar-dropdown preview-list\" aria-labelledby=\"messageDropdown\">
                            <h6 class=\"p-3 mb-0\">Messages</h6>
                            <div class=\"dropdown-divider\"></div>
                            <a class=\"dropdown-item preview-item\">
                                <div class=\"preview-thumbnail\">
                                    <img src=\"{{ asset('Back/assets/images/faces/face4.jpg') }}\" alt=\"image\" class=\"rounded-circle profile-pic\">
                                </div>
                                <div class=\"preview-item-content\">
                                    <p class=\"preview-subject ellipsis mb-1\">Mark send you a message</p>
                                    <p class=\"text-muted mb-0\"> 1 Minutes ago </p>
                                </div>
                            </a>
                            <div class=\"dropdown-divider\"></div>
                            <a class=\"dropdown-item preview-item\">
                                <div class=\"preview-thumbnail\">
                                    <img src=\"{{ asset('Back/assets/images/faces/face2.jpg') }}\" alt=\"image\" class=\"rounded-circle profile-pic\">
                                </div>
                                <div class=\"preview-item-content\">
                                    <p class=\"preview-subject ellipsis mb-1\">Cregh send you a message</p>
                                    <p class=\"text-muted mb-0\"> 15 Minutes ago </p>
                                </div>
                            </a>
                            <div class=\"dropdown-divider\"></div>
                            <a class=\"dropdown-item preview-item\">
                                <div class=\"preview-thumbnail\">
                                    <img src=\"{{ asset('Back/assets/images/faces/face3.jpg') }}\" alt=\"image\" class=\"rounded-circle profile-pic\">
                                </div>
                                <div class=\"preview-item-content\">
                                    <p class=\"preview-subject ellipsis mb-1\">Profile picture updated</p>
                                    <p class=\"text-muted mb-0\"> 18 Minutes ago </p>
                                </div>
                            </a>
                            <div class=\"dropdown-divider\"></div>
                            <p class=\"p-3 mb-0 text-center\">4 new messages</p>
                        </div>
                    </li>
                    <li class=\"nav-item dropdown border-left\">
                        <a class=\"nav-link count-indicator dropdown-toggle\" id=\"notificationDropdown\" href=\"#\" data-toggle=\"dropdown\">
                            <i class=\"mdi mdi-bell\"></i>
                            <span class=\"count bg-danger\"></span>
                        </a>
                        <div class=\"dropdown-menu dropdown-menu-right navbar-dropdown preview-list\" aria-labelledby=\"notificationDropdown\">
                            <h6 class=\"p-3 mb-0\">Notifications</h6>
                            <div class=\"dropdown-divider\"></div>
                            <a class=\"dropdown-item preview-item\">
                                <div class=\"preview-thumbnail\">
                                    <div class=\"preview-icon bg-dark rounded-circle\">
                                        <i class=\"mdi mdi-calendar text-success\"></i>
                                    </div>
                                </div>
                                <div class=\"preview-item-content\">
                                    <p class=\"preview-subject mb-1\">Event today</p>
                                    <p class=\"text-muted ellipsis mb-0\"> Just a reminder that you have an event today </p>
                                </div>
                            </a>
                            <div class=\"dropdown-divider\"></div>
                            <a class=\"dropdown-item preview-item\">
                                <div class=\"preview-thumbnail\">
                                    <div class=\"preview-icon bg-dark rounded-circle\">
                                        <i class=\"mdi mdi-settings text-danger\"></i>
                                    </div>
                                </div>
                                <div class=\"preview-item-content\">
                                    <p class=\"preview-subject mb-1\">Settings</p>
                                    <p class=\"text-muted ellipsis mb-0\"> Update dashboard </p>
                                </div>
                            </a>
                            <div class=\"dropdown-divider\"></div>
                            <a class=\"dropdown-item preview-item\">
                                <div class=\"preview-thumbnail\">
                                    <div class=\"preview-icon bg-dark rounded-circle\">
                                        <i class=\"mdi mdi-link-variant text-warning\"></i>
                                    </div>
                                </div>
                                <div class=\"preview-item-content\">
                                    <p class=\"preview-subject mb-1\">Launch Admin</p>
                                    <p class=\"text-muted ellipsis mb-0\"> New admin wow! </p>
                                </div>
                            </a>
                            <div class=\"dropdown-divider\"></div>
                            <p class=\"p-3 mb-0 text-center\">See all notifications</p>
                        </div>
                    </li>
                    <li class=\"nav-item dropdown\">
                        <a class=\"nav-link\" id=\"profileDropdown\" href=\"#\" data-toggle=\"dropdown\">
                            <div class=\"navbar-profile\">
                                <img class=\"img-xs rounded-circle\" src=\"{{ asset('Back/assets/images/faces/face15.jpg') }}\" alt=\"\">
                                <p class=\"mb-0 d-none d-sm-block navbar-profile-name\">{{ app.user.firstname ~ \" \" ~ app.user.lastname }}</p>
                                <i class=\"mdi mdi-menu-down d-none d-sm-block\"></i>
                            </div>
                        </a>
                        <div class=\"dropdown-menu dropdown-menu-right navbar-dropdown preview-list\" aria-labelledby=\"profileDropdown\">
                            <h6 class=\"p-3 mb-0\">Profile</h6>
                            <div class=\"dropdown-divider\"></div>
                            <a class=\"dropdown-item preview-item\">
                                <div class=\"preview-thumbnail\">
                                    <div class=\"preview-icon bg-dark rounded-circle\">
                                        <i class=\"mdi mdi-settings text-success\"></i>
                                    </div>
                                </div>
                                <div class=\"preview-item-content\">
                                    <p class=\"preview-subject mb-1\">Settings</p>
                                </div>
                            </a>
                            <div class=\"dropdown-divider\"></div>
                            <a href=\"{{ path('app_logout') }}\" class=\"dropdown-item preview-item\">
                                <div class=\"preview-thumbnail\">
                                    <div class=\"preview-icon bg-dark rounded-circle\">
                                        <i class=\"mdi mdi-logout text-danger\"></i>
                                    </div>
                                </div>
                                <div class=\"preview-item-content\">
                                    <p class=\"preview-subject mb-1\">Log Out</p>
                                </div>
                            </a>
                            <div class=\"dropdown-divider\"></div>
                            <p class=\"p-3 mb-0 text-center\">Advanced settings</p>
                        </div>
                    </li>
                </ul>
                <button class=\"navbar-toggler navbar-toggler-right d-lg-none align-self-center\" type=\"button\" data-toggle=\"offcanvas\">
                    <span class=\"mdi mdi-format-line-spacing\"></span>
                </button>
            </div>
        </nav>
{% endblock %}

{% block body %}

{% endblock %}
</div>
</div>

<!-- container-scroller -->
</body>

{% block javascripts %}

    <!-- container-scroller -->
    <!-- plugins:js -->
    <script src=\"{{ asset('Back/assets/vendors/js/vendor.bundle.base.js') }}\"></script>
    <!-- endinject -->
    <!-- Plugin js for this page -->
    <script src=\"{{ asset('Back/assets/vendors/chart.js/Chart.min.js') }}\"></script>
    <script src=\"{{ asset('Back/assets/vendors/progressbar.js/progressbar.min.js') }}\"></script>
    <script src=\"{{ asset('Back/assets/vendors/jvectormap/jquery-jvectormap.min.js') }}\"></script>
    <script src=\"{{ asset('Back/assets/vendors/jvectormap/jquery-jvectormap-world-mill-en.js') }}\"></script>
    <script src=\"{{ asset('Back/assets/vendors/owl-carousel-2/owl.carousel.min.js') }}\"></script>
    <!-- End plugin js for this page -->
    <!-- inject:js -->
    <script src=\"{{ asset('Back/assets/js/off-canvas.js') }}\"></script>
    <script src=\"{{ asset('Back/assets/js/hoverable-collapse.js') }}\"></script>
    <script src=\"{{ asset('Back/assets/js/misc.js') }}\"></script>
    <script src=\"{{ asset('Back/assets/js/settings.js') }}\"></script>
    <script src=\"{{ asset('Back/assets/js/todolist.js') }}\"></script>
    <!-- endinject -->
    <!-- Custom js for this page -->
    <script src=\"{{ asset('Back/assets/js/dashboard.js') }}\"></script>
    <!-- End custom js for this page -->

{% endblock %}


</html>
", "baseBack.html.twig", "C:\\Users\\Yassine\\Desktop\\gamex_login\\templates\\baseBack.html.twig");
    }
}
