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

/* user/index.html.twig */
class __TwigTemplate_abee4f93f5983c7b554e06c3545d7ecff68411ba43743479e11b9d04681b99a8 extends Template
{
    private $source;
    private $macros = [];

    public function __construct(Environment $env)
    {
        parent::__construct($env);

        $this->source = $this->getSourceContext();

        $this->blocks = [
            'stylesheets' => [$this, 'block_stylesheets'],
            'body' => [$this, 'block_body'],
        ];
    }

    protected function doGetParent(array $context)
    {
        // line 1
        return "baseBack.html.twig";
    }

    protected function doDisplay(array $context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "user/index.html.twig"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "user/index.html.twig"));

        $this->parent = $this->loadTemplate("baseBack.html.twig", "user/index.html.twig", 1);
        $this->parent->display($context, array_merge($this->blocks, $blocks));
        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

    }

    // line 3
    public function block_stylesheets($context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "stylesheets"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "stylesheets"));

        // line 4
        echo "    <!-- Required meta tags -->
    <meta charset=\"utf-8\">
    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
    <title>GAMEX</title>
    <!-- plugins:css -->
    <link rel=\"stylesheet\" href=\"";
        // line 9
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/vendors/mdi/css/materialdesignicons.min.css"), "html", null, true);
        echo "\">
    <link rel=\"stylesheet\" href=\"";
        // line 10
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/vendors/css/vendor.bundle.base.css"), "html", null, true);
        echo "\">
    <!-- endinject -->
    <!-- Plugin css for this page -->
    <link rel=\"stylesheet\" href=\"";
        // line 13
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/vendors/jvectormap/jquery-jvectormap.css"), "html", null, true);
        echo "\">
    <link rel=\"stylesheet\" href=\"";
        // line 14
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/vendors/flag-icon-css/css/flag-icon.min.css"), "html", null, true);
        echo "\">
    <link rel=\"stylesheet\" href=\"";
        // line 15
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/vendors/owl-carousel-2/owl.carousel.min.css"), "html", null, true);
        echo "\">
    <link rel=\"stylesheet\" href=\"";
        // line 16
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/vendors/owl-carousel-2/owl.theme.default.min.css"), "html", null, true);
        echo "\">
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <!-- endinject -->
    <!-- Layout styles -->
    <link rel=\"stylesheet\" href=\"";
        // line 21
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/css/style.css"), "html", null, true);
        echo "\">
    <!-- End layout styles -->
    <link rel=\"shortcut icon\" href=\"";
        // line 23
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/images/favicon.png"), "html", null, true);
        echo "\" />

    <style>

        .pagination{
            justify-content: center;
        }
        .current{
            margin: 0px 5px 0px 5px;
            border-radius: 50%;
            width: 2%;
            text-align: center;
            border: solid #0090e7;
        }

        .page{
            margin: 0px 5px 0px 5px;
            border-radius: 50%;
            width: 2%;
            text-align: center;
            border: solid #0090e7;
        }

        .page a{
            color: white;
        }

        .previous a{
            color: white;
            margin-left: 5px;
            border-bottom: 1px solid #00d25b;
        }
        .next a{
            color: white;
            margin-right: 5px;
            border-bottom: 1px solid #00d25b;
        }

        .first a{
            color: #00d25b;
            margin-left: 5px;
            border-bottom: 1px solid #00d25b;
        }
        .last a{
            color: #00d25b;
            border-bottom: 1px solid #00d25b;
        }
    </style>

    <style>
        .form-check .form-check-label input[type=\"radio\"] + .input-helper:before {
            border: solid #00d25b;

        }

        .form-check .form-check-label input[type=\"radio\"]:checked + .input-helper:before {
            background-color: #00d25b;
        }
    </style>
";
        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

    }

    // line 84
    public function block_body($context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "body"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "body"));

        // line 85
        echo "    <div class=\"main-panel\">
        <div class=\"content-wrapper\">
            <div class=\"page-header\">
                <h3 class=\"page-title\">ADMIN INTERFACE </h3>

            </div>
            <div class=\"row\">
                <div class=\"col-lg-12 grid-margin stretch-card\">
                    <div class=\"card\">
                        <div class=\"card-body\">
                            <div style=\"display: flex\">
                                <div class=\"col-md-7\">
                                    <h4 class=\"card-title\">USERS</h4>
                                </div>
                                <form method=\"post\" class=\"forms-sample\" style=\"margin-left: 29px\" >
                                    <div class=\"form-group col-md-4\" style=\"display: flex; width: 100%!important; margin: 0px!important;\">

                                        <div class=\"form-check\">
                                            <label class=\"form-check-label\" style=\"width: 55px;margin-left: -2px;margin-right: 10px;\">
                                                <input style=\"border: solid #00d25b;\" type=\"radio\" class=\"form-check-input\" name=\"optionsRadios\" id=\"optionsRadios1\" value=\"email\"> Email </label>
                                        </div>
                                        <div class=\"form-check\">
                                            <label class=\"form-check-label\" style=\"width: 78px;margin-left: -2px;margin-right: 10px;\">
                                                <input type=\"radio\" class=\"form-check-input\" name=\"optionsRadios\" id=\"optionsRadios2\" value=\"firstname\" > Full name </label>
                                        </div>
                                        <div class=\"form-check\">
                                            <label class=\"form-check-label\" style=\"width: 79px;margin-left: -2px;margin-right: 10px;\">
                                                <input type=\"radio\" class=\"form-check-input\" name=\"optionsRadios\" id=\"optionsRadios3\" value=\"usertag\" > Username </label>
                                        </div>
                                        <div class=\"form-check\">
                                            <label class=\"form-check-label\" style=\"width: 118px;margin-left: -2px;margin-right: 10px;\">
                                                <input type=\"radio\" class=\"form-check-input\" name=\"optionsRadios\" id=\"optionsRadios4\" value=\"phonenumber\"  > Phone Number </label>
                                        </div>
                                        <button type=\"Submit\" class=\"btn btn-success btn-fw\">Sort</button>
                                    </div>
                                </form>

                            </div>
                            <p class=\"card-description\">only someone with administrative priviliges has access to this page</code>
                            </p>
                            <ul class=\"navbar-nav w-100\">
                                <li class=\"nav-item w-100\">
                                    <form name=\"Search-method\" id=\"Search-method\"method=\"post\" class=\"forms-sample\" style=\"display: flex\">
                                        <div class=\"form-group col-md-3\">
                                            <label style=\"margin-top: 11px;margin-left: 10px;margin-right: 14px;border-bottom: 6px solid #0090e7;padding-bottom: 7px;border-bottom-style: dotted;\">Search Options</label>
                                            <select name=\"optionsearch\" class=\"js-example-basic-single\" style=\"width: 200px;height: 38px; color: white; background-color: #191c24; border-radius: 4px;text-align: center;border: 2px solid #0090e7;margin-right: 15px;\">
                                                <option value=\"email\">Email</option>
                                                <option value=\"firstname\">First Name</option>
                                                <option value=\"lastname\">Last Name</option>
                                                <option value=\"usertag\">UserName</option>
                                                <option value=\"phonenumber\">Phone Number</option>
                                            </select>
                                        </div>
                                        <div class=\"form-group col-md-9\">
                                            <div class=\"input-group\">
                                                <input name=\"Search\" type=\"text\" class=\"form-control\" placeholder=\"Search Users\" aria-label=\"Recipient's username\" aria-describedby=\"basic-addon2\">
                                                <div class=\"input-group-append\">
                                                    <button class=\"btn btn-sm btn-primary\" type=\"Submit\">Search</button>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </li>
                            </ul>
                            ";
        // line 149
        if ( !twig_get_attribute($this->env, $this->source, (isset($context["users"]) || array_key_exists("users", $context) ? $context["users"] : (function () { throw new RuntimeError('Variable "users" does not exist.', 149, $this->source); })()), "items", [], "any", false, false, false, 149)) {
            // line 150
            echo "                            <div style=\"display: grid;\">
                                <label style=\"width: 22%;margin: auto;margin-bottom: 13px;margin-top: 10px;border: 2px solid #0090e7;padding: 10px;border-radius: 20px;border-left: 2px solid red;border-right: 2px solid red;text-align: center; font-style: oblique;color: chartreuse;\"> NO USERS FOUND WITH SUCH CRITERIA</label>
                            </div>
                            ";
        } else {
            // line 154
            echo "                            <div class=\"table-responsive\">
                                <table class=\"table\">
                                    <thead>
                                    <tr>
                                        <th>Username</th>
                                        <th>Email</th>
                                        <th>Phone number</th>
                                        <th>Roles</th>
                                        <th>Password</th>
                                        <th>full name</th>
                                        <th>actions</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    ";
            // line 168
            $context['_parent'] = $context;
            $context['_seq'] = twig_ensure_traversable((isset($context["users"]) || array_key_exists("users", $context) ? $context["users"] : (function () { throw new RuntimeError('Variable "users" does not exist.', 168, $this->source); })()));
            foreach ($context['_seq'] as $context["_key"] => $context["user"]) {
                // line 169
                echo "                                        <tr>
                                            <td>";
                // line 170
                echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, $context["user"], "usertag", [], "any", false, false, false, 170), "html", null, true);
                echo "</td>
                                            <td>";
                // line 171
                echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, $context["user"], "username", [], "any", false, false, false, 171), "html", null, true);
                echo "</td>
                                            <td>";
                // line 172
                echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, $context["user"], "phonenumber", [], "any", false, false, false, 172), "html", null, true);
                echo "</td>

                                            <td>
                                                ";
                // line 175
                $context['_parent'] = $context;
                $context['_seq'] = twig_ensure_traversable(twig_get_attribute($this->env, $this->source, $context["user"], "roles", [], "any", false, false, false, 175));
                foreach ($context['_seq'] as $context["_key"] => $context["role"]) {
                    // line 176
                    echo "                                                    ";
                    if ((0 === twig_compare($context["role"], "ROLE_ADMIN"))) {
                        // line 177
                        echo "                                                        <label class=\"badge badge-success\">ADMIN</label>
                                                    ";
                    } elseif ((0 === twig_compare(                    // line 178
$context["role"], "ROLE_PLAYER"))) {
                        // line 179
                        echo "                                                        <label class=\"badge badge-info\">PLAYER</label>
                                                    ";
                    } elseif ((0 === twig_compare(                    // line 180
$context["role"], "ROLE_USER"))) {
                        // line 181
                        echo "                                                        <label class=\"badge badge-warning\">USER</label>
                                                    ";
                    }
                    // line 183
                    echo "                                                ";
                }
                $_parent = $context['_parent'];
                unset($context['_seq'], $context['_iterated'], $context['_key'], $context['role'], $context['_parent'], $context['loop']);
                $context = array_intersect_key($context, $_parent) + $_parent;
                // line 184
                echo "                                            </td>

                                            <td>Crypted</td>
                                            <td>";
                // line 187
                echo twig_escape_filter($this->env, ((twig_get_attribute($this->env, $this->source, $context["user"], "firstname", [], "any", false, false, false, 187) . " ") . twig_get_attribute($this->env, $this->source, $context["user"], "lastname", [], "any", false, false, false, 187)), "html", null, true);
                echo "</td>

                                            <td>
                                                <a class=\"btn btn-outline-primary btn-fw\" href=\"";
                // line 190
                echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("user_show", ["id" => twig_get_attribute($this->env, $this->source, $context["user"], "id", [], "any", false, false, false, 190)]), "html", null, true);
                echo "\">show</a>
                                                <a class=\"btn btn-outline-primary btn-fw\" href=\"";
                // line 191
                echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("user_edit", ["id" => twig_get_attribute($this->env, $this->source, $context["user"], "id", [], "any", false, false, false, 191)]), "html", null, true);
                echo "\">edit</a>
                                            </td>
                                        </tr>



                                    ";
            }
            $_parent = $context['_parent'];
            unset($context['_seq'], $context['_iterated'], $context['_key'], $context['user'], $context['_parent'], $context['loop']);
            $context = array_intersect_key($context, $_parent) + $_parent;
            // line 198
            echo "
                                    ";
        }
        // line 200
        echo "
                                    </tbody>
                                </table>

                                ";
        // line 204
        echo $this->extensions['Knp\Bundle\PaginatorBundle\Twig\Extension\PaginationExtension']->render($this->env, (isset($context["users"]) || array_key_exists("users", $context) ? $context["users"] : (function () { throw new RuntimeError('Variable "users" does not exist.', 204, $this->source); })()));
        echo "

                                ";
        // line 206
        if ((isset($context["back"]) || array_key_exists("back", $context) ? $context["back"] : (function () { throw new RuntimeError('Variable "back" does not exist.', 206, $this->source); })())) {
            // line 207
            echo "                                    <div style=\"display: grid; margin-top: 20px;\">
                                        <a class=\"btn btn-outline-primary btn-fw\" href=\"";
            // line 208
            echo $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("user_index");
            echo "\">Back</a>
                                    </div>
                                ";
        }
        // line 211
        echo "                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
";
        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

    }

    public function getTemplateName()
    {
        return "user/index.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  383 => 211,  377 => 208,  374 => 207,  372 => 206,  367 => 204,  361 => 200,  357 => 198,  344 => 191,  340 => 190,  334 => 187,  329 => 184,  323 => 183,  319 => 181,  317 => 180,  314 => 179,  312 => 178,  309 => 177,  306 => 176,  302 => 175,  296 => 172,  292 => 171,  288 => 170,  285 => 169,  281 => 168,  265 => 154,  259 => 150,  257 => 149,  191 => 85,  181 => 84,  111 => 23,  106 => 21,  98 => 16,  94 => 15,  90 => 14,  86 => 13,  80 => 10,  76 => 9,  69 => 4,  59 => 3,  36 => 1,);
    }

    public function getSourceContext()
    {
        return new Source("{% extends 'baseBack.html.twig' %}

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

    <style>

        .pagination{
            justify-content: center;
        }
        .current{
            margin: 0px 5px 0px 5px;
            border-radius: 50%;
            width: 2%;
            text-align: center;
            border: solid #0090e7;
        }

        .page{
            margin: 0px 5px 0px 5px;
            border-radius: 50%;
            width: 2%;
            text-align: center;
            border: solid #0090e7;
        }

        .page a{
            color: white;
        }

        .previous a{
            color: white;
            margin-left: 5px;
            border-bottom: 1px solid #00d25b;
        }
        .next a{
            color: white;
            margin-right: 5px;
            border-bottom: 1px solid #00d25b;
        }

        .first a{
            color: #00d25b;
            margin-left: 5px;
            border-bottom: 1px solid #00d25b;
        }
        .last a{
            color: #00d25b;
            border-bottom: 1px solid #00d25b;
        }
    </style>

    <style>
        .form-check .form-check-label input[type=\"radio\"] + .input-helper:before {
            border: solid #00d25b;

        }

        .form-check .form-check-label input[type=\"radio\"]:checked + .input-helper:before {
            background-color: #00d25b;
        }
    </style>
{% endblock %}

{% block body %}
    <div class=\"main-panel\">
        <div class=\"content-wrapper\">
            <div class=\"page-header\">
                <h3 class=\"page-title\">ADMIN INTERFACE </h3>

            </div>
            <div class=\"row\">
                <div class=\"col-lg-12 grid-margin stretch-card\">
                    <div class=\"card\">
                        <div class=\"card-body\">
                            <div style=\"display: flex\">
                                <div class=\"col-md-7\">
                                    <h4 class=\"card-title\">USERS</h4>
                                </div>
                                <form method=\"post\" class=\"forms-sample\" style=\"margin-left: 29px\" >
                                    <div class=\"form-group col-md-4\" style=\"display: flex; width: 100%!important; margin: 0px!important;\">

                                        <div class=\"form-check\">
                                            <label class=\"form-check-label\" style=\"width: 55px;margin-left: -2px;margin-right: 10px;\">
                                                <input style=\"border: solid #00d25b;\" type=\"radio\" class=\"form-check-input\" name=\"optionsRadios\" id=\"optionsRadios1\" value=\"email\"> Email </label>
                                        </div>
                                        <div class=\"form-check\">
                                            <label class=\"form-check-label\" style=\"width: 78px;margin-left: -2px;margin-right: 10px;\">
                                                <input type=\"radio\" class=\"form-check-input\" name=\"optionsRadios\" id=\"optionsRadios2\" value=\"firstname\" > Full name </label>
                                        </div>
                                        <div class=\"form-check\">
                                            <label class=\"form-check-label\" style=\"width: 79px;margin-left: -2px;margin-right: 10px;\">
                                                <input type=\"radio\" class=\"form-check-input\" name=\"optionsRadios\" id=\"optionsRadios3\" value=\"usertag\" > Username </label>
                                        </div>
                                        <div class=\"form-check\">
                                            <label class=\"form-check-label\" style=\"width: 118px;margin-left: -2px;margin-right: 10px;\">
                                                <input type=\"radio\" class=\"form-check-input\" name=\"optionsRadios\" id=\"optionsRadios4\" value=\"phonenumber\"  > Phone Number </label>
                                        </div>
                                        <button type=\"Submit\" class=\"btn btn-success btn-fw\">Sort</button>
                                    </div>
                                </form>

                            </div>
                            <p class=\"card-description\">only someone with administrative priviliges has access to this page</code>
                            </p>
                            <ul class=\"navbar-nav w-100\">
                                <li class=\"nav-item w-100\">
                                    <form name=\"Search-method\" id=\"Search-method\"method=\"post\" class=\"forms-sample\" style=\"display: flex\">
                                        <div class=\"form-group col-md-3\">
                                            <label style=\"margin-top: 11px;margin-left: 10px;margin-right: 14px;border-bottom: 6px solid #0090e7;padding-bottom: 7px;border-bottom-style: dotted;\">Search Options</label>
                                            <select name=\"optionsearch\" class=\"js-example-basic-single\" style=\"width: 200px;height: 38px; color: white; background-color: #191c24; border-radius: 4px;text-align: center;border: 2px solid #0090e7;margin-right: 15px;\">
                                                <option value=\"email\">Email</option>
                                                <option value=\"firstname\">First Name</option>
                                                <option value=\"lastname\">Last Name</option>
                                                <option value=\"usertag\">UserName</option>
                                                <option value=\"phonenumber\">Phone Number</option>
                                            </select>
                                        </div>
                                        <div class=\"form-group col-md-9\">
                                            <div class=\"input-group\">
                                                <input name=\"Search\" type=\"text\" class=\"form-control\" placeholder=\"Search Users\" aria-label=\"Recipient's username\" aria-describedby=\"basic-addon2\">
                                                <div class=\"input-group-append\">
                                                    <button class=\"btn btn-sm btn-primary\" type=\"Submit\">Search</button>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </li>
                            </ul>
                            {% if not (users.items) %}
                            <div style=\"display: grid;\">
                                <label style=\"width: 22%;margin: auto;margin-bottom: 13px;margin-top: 10px;border: 2px solid #0090e7;padding: 10px;border-radius: 20px;border-left: 2px solid red;border-right: 2px solid red;text-align: center; font-style: oblique;color: chartreuse;\"> NO USERS FOUND WITH SUCH CRITERIA</label>
                            </div>
                            {% else %}
                            <div class=\"table-responsive\">
                                <table class=\"table\">
                                    <thead>
                                    <tr>
                                        <th>Username</th>
                                        <th>Email</th>
                                        <th>Phone number</th>
                                        <th>Roles</th>
                                        <th>Password</th>
                                        <th>full name</th>
                                        <th>actions</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    {% for user in users %}
                                        <tr>
                                            <td>{{ user.usertag }}</td>
                                            <td>{{ user.username }}</td>
                                            <td>{{ user.phonenumber }}</td>

                                            <td>
                                                {% for role in user.roles %}
                                                    {% if role == 'ROLE_ADMIN' %}
                                                        <label class=\"badge badge-success\">ADMIN</label>
                                                    {% elseif role == 'ROLE_PLAYER'%}
                                                        <label class=\"badge badge-info\">PLAYER</label>
                                                    {% elseif role == 'ROLE_USER' %}
                                                        <label class=\"badge badge-warning\">USER</label>
                                                    {% endif %}
                                                {% endfor %}
                                            </td>

                                            <td>Crypted</td>
                                            <td>{{ user.firstname ~ \" \" ~ user.lastname}}</td>

                                            <td>
                                                <a class=\"btn btn-outline-primary btn-fw\" href=\"{{ path('user_show', {'id': user.id}) }}\">show</a>
                                                <a class=\"btn btn-outline-primary btn-fw\" href=\"{{ path('user_edit', {'id': user.id}) }}\">edit</a>
                                            </td>
                                        </tr>



                                    {% endfor %}

                                    {% endif %}

                                    </tbody>
                                </table>

                                {{ knp_pagination_render(users) }}

                                {% if (back) %}
                                    <div style=\"display: grid; margin-top: 20px;\">
                                        <a class=\"btn btn-outline-primary btn-fw\" href=\"{{ path('user_index') }}\">Back</a>
                                    </div>
                                {% endif %}
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
{% endblock %}
", "user/index.html.twig", "C:\\Users\\Yassine\\Desktop\\git-login-symfony\\templates\\user\\index.html.twig");
    }
}
