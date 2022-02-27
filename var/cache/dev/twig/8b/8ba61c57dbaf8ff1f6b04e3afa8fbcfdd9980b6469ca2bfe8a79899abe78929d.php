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
class __TwigTemplate_8ac201547cb498a4e521ee68b1ecee60a9dee89aa5afb7dfbbb110af0954e8d5 extends Template
{
    private $source;
    private $macros = [];

    public function __construct(Environment $env)
    {
        parent::__construct($env);

        $this->source = $this->getSourceContext();

        $this->blocks = [
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

    // line 4
    public function block_body($context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "body"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "body"));

        // line 5
        echo "    <div class=\"main-panel\">
        <div class=\"content-wrapper\">
            <div class=\"page-header\">
                <h3 class=\"page-title\">ADMIN INTERFACE </h3>

            </div>
            <div class=\"row\">
                <div class=\"col-lg-12 grid-margin stretch-card\">
                    <div class=\"card\">
                        <div class=\"card-body\">
                            <h4 class=\"card-title\">USERS</h4>
                            <p class=\"card-description\">only someone with administrative priviliges has access to this page</code>
                            </p>
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
                                    ";
        // line 32
        $context['_parent'] = $context;
        $context['_seq'] = twig_ensure_traversable((isset($context["users"]) || array_key_exists("users", $context) ? $context["users"] : (function () { throw new RuntimeError('Variable "users" does not exist.', 32, $this->source); })()));
        foreach ($context['_seq'] as $context["_key"] => $context["user"]) {
            // line 33
            echo "                                        <tr>
                                            <td>";
            // line 34
            echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, $context["user"], "usertag", [], "any", false, false, false, 34), "html", null, true);
            echo "</td>
                                            <td>";
            // line 35
            echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, $context["user"], "username", [], "any", false, false, false, 35), "html", null, true);
            echo "</td>
                                            <td>";
            // line 36
            echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, $context["user"], "phonenumber", [], "any", false, false, false, 36), "html", null, true);
            echo "</td>

                                            <td>
                                                ";
            // line 39
            $context['_parent'] = $context;
            $context['_seq'] = twig_ensure_traversable(twig_get_attribute($this->env, $this->source, $context["user"], "roles", [], "any", false, false, false, 39));
            foreach ($context['_seq'] as $context["_key"] => $context["role"]) {
                // line 40
                echo "                                                    ";
                if ((0 === twig_compare($context["role"], "ROLE_ADMIN"))) {
                    // line 41
                    echo "                                                        <label class=\"badge badge-success\">ADMIN</label>
                                                    ";
                } elseif ((0 === twig_compare(                // line 42
$context["role"], "ROLE_PLAYER"))) {
                    // line 43
                    echo "                                                        <label class=\"badge badge-info\">PLAYER</label>
                                                    ";
                } elseif ((0 === twig_compare(                // line 44
$context["role"], "ROLE_USER"))) {
                    // line 45
                    echo "                                                        <label class=\"badge badge-warning\">USER</label>
                                                    ";
                }
                // line 47
                echo "                                                ";
            }
            $_parent = $context['_parent'];
            unset($context['_seq'], $context['_iterated'], $context['_key'], $context['role'], $context['_parent'], $context['loop']);
            $context = array_intersect_key($context, $_parent) + $_parent;
            // line 48
            echo "                                            </td>

                                            <td>Crypted</td>
                                            <td>";
            // line 51
            echo twig_escape_filter($this->env, ((twig_get_attribute($this->env, $this->source, $context["user"], "firstname", [], "any", false, false, false, 51) . " ") . twig_get_attribute($this->env, $this->source, $context["user"], "lastname", [], "any", false, false, false, 51)), "html", null, true);
            echo "</td>

                                            <td>
                                                <a class=\"btn btn-outline-primary btn-fw\" href=\"";
            // line 54
            echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("user_show", ["id" => twig_get_attribute($this->env, $this->source, $context["user"], "id", [], "any", false, false, false, 54)]), "html", null, true);
            echo "\">show</a>
                                                <a class=\"btn btn-outline-primary btn-fw\" href=\"";
            // line 55
            echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("user_edit", ["id" => twig_get_attribute($this->env, $this->source, $context["user"], "id", [], "any", false, false, false, 55)]), "html", null, true);
            echo "\">edit</a>
                                            </td>
                                        </tr>



                                    ";
        }
        $_parent = $context['_parent'];
        unset($context['_seq'], $context['_iterated'], $context['_key'], $context['user'], $context['_parent'], $context['loop']);
        $context = array_intersect_key($context, $_parent) + $_parent;
        // line 62
        echo "                                    </tbody>
                                </table>
                            </div>
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
        return array (  173 => 62,  160 => 55,  156 => 54,  150 => 51,  145 => 48,  139 => 47,  135 => 45,  133 => 44,  130 => 43,  128 => 42,  125 => 41,  122 => 40,  118 => 39,  112 => 36,  108 => 35,  104 => 34,  101 => 33,  97 => 32,  68 => 5,  58 => 4,  35 => 1,);
    }

    public function getSourceContext()
    {
        return new Source("{% extends 'baseBack.html.twig' %}


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
                            <h4 class=\"card-title\">USERS</h4>
                            <p class=\"card-description\">only someone with administrative priviliges has access to this page</code>
                            </p>
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
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
{% endblock %}
", "user/index.html.twig", "C:\\Users\\Yassine\\Desktop\\gamex_login\\templates\\user\\index.html.twig");
    }
}
