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

/* user/edit.html.twig */
class __TwigTemplate_1d40051fc4b4b440f585959d78dad71ab7b6f3349aee6fd707a340872392516d extends Template
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
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "user/edit.html.twig"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "user/edit.html.twig"));

        $this->parent = $this->loadTemplate("baseBack.html.twig", "user/edit.html.twig", 1);
        $this->parent->display($context, array_merge($this->blocks, $blocks));
        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

    }

    // line 3
    public function block_body($context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "body"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "body"));

        // line 4
        echo "
        <div  class=\"main-panel\">
            <div class=\"content-wrapper\">
                <div class=\"page-header\">
                    <h3 class=\"page-title\"> Profile </h3>

                </div>
                <div class=\"row\">
                    <div class=\"col-md-6 grid-margin stretch-card\">
                        <div class=\"card\">
                            <div class=\"card-body\">

                                <div class=\"row align-items-right\">
                                    <div class=\"col-7\">
                                        <h4 class=\"card-title\">User Information</h4>
                                    </div>
                                    <div class=\"col-4 text-right\" style=\"display: -webkit-box;\">
                                        <a  style=\"margin-left: -23px;\" class=\"btn btn-outline-primary btn-fw\" href=\"";
        // line 21
        echo $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("user_index");
        echo "\">Back</a>
                                        <form style=\" margin-left: 15px;\" method=\"post\" action=\"";
        // line 22
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("user_delete", ["id" => twig_get_attribute($this->env, $this->source, (isset($context["user"]) || array_key_exists("user", $context) ? $context["user"] : (function () { throw new RuntimeError('Variable "user" does not exist.', 22, $this->source); })()), "id", [], "any", false, false, false, 22)]), "html", null, true);
        echo "\" onsubmit=\"return confirm('Are you sure you want to delete this item?');\">
                                            <input type=\"hidden\" name=\"_token\" value=\"";
        // line 23
        echo twig_escape_filter($this->env, $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->renderCsrfToken(("delete" . twig_get_attribute($this->env, $this->source, (isset($context["user"]) || array_key_exists("user", $context) ? $context["user"] : (function () { throw new RuntimeError('Variable "user" does not exist.', 23, $this->source); })()), "id", [], "any", false, false, false, 23))), "html", null, true);
        echo "\">
                                            <button class=\"btn btn-outline-danger btn-fw\">Delete</button>
                                        </form>
                                    </div>
                                </div>
                                <div class=\"row align-items-center\">
                                    <div class=\"col-12\">
                                        ";
        // line 30
        if ( !twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 30, $this->source); })()), "vars", [], "any", false, false, false, 30), "valid", [], "any", false, false, false, 30)) {
            // line 31
            echo "                                            ";
            $context['_parent'] = $context;
            $context['_seq'] = twig_ensure_traversable(twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 31, $this->source); })()), "children", [], "any", false, false, false, 31));
            foreach ($context['_seq'] as $context["_key"] => $context["child"]) {
                // line 32
                echo "                                                ";
                $context['_parent'] = $context;
                $context['_seq'] = twig_ensure_traversable(twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, $context["child"], "vars", [], "any", false, false, false, 32), "errors", [], "any", false, false, false, 32));
                foreach ($context['_seq'] as $context["_key"] => $context["error"]) {
                    // line 33
                    echo "                                                    <div class=\"alert alert-danger\">";
                    echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, $context["error"], "message", [], "any", false, false, false, 33), "html", null, true);
                    echo "</div>
                                                ";
                }
                $_parent = $context['_parent'];
                unset($context['_seq'], $context['_iterated'], $context['_key'], $context['error'], $context['_parent'], $context['loop']);
                $context = array_intersect_key($context, $_parent) + $_parent;
                // line 35
                echo "                                            ";
            }
            $_parent = $context['_parent'];
            unset($context['_seq'], $context['_iterated'], $context['_key'], $context['child'], $context['_parent'], $context['loop']);
            $context = array_intersect_key($context, $_parent) + $_parent;
            // line 36
            echo "                                        ";
        }
        // line 37
        echo "                                    </div>
                                </div>

                                <p class=\"card-description\">  </p>
                                ";
        // line 41
        echo         $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->renderBlock((isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 41, $this->source); })()), 'form_start');
        echo "
                                <div class=\"form-group\">
                                    <label for=\"exampleInputUsername1\">Email</label>
                                    ";
        // line 44
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 44, $this->source); })()), "email", [], "any", false, false, false, 44), 'widget', ["attr" => ["class" => "form-control"]]);
        echo "
                                </div>
                                <div class=\"form-group\">
                                    <label for=\"exampleInputPassword1\">Username</label>
                                    ";
        // line 48
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 48, $this->source); })()), "usertag", [], "any", false, false, false, 48), 'widget', ["attr" => ["class" => "form-control"]]);
        echo "
                                </div>
                                <div class=\"form-group\">
                                    <label >First name</label>
                                    ";
        // line 52
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 52, $this->source); })()), "firstname", [], "any", false, false, false, 52), 'widget', ["attr" => ["class" => "form-control"]]);
        echo "
                                </div>
                                <div class=\"form-group\">
                                    <label for=\"exampleInputPassword1\">last name</label>
                                    ";
        // line 56
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 56, $this->source); })()), "lastname", [], "any", false, false, false, 56), 'widget', ["attr" => ["class" => "form-control"]]);
        echo "
                                </div>
                                <div class=\"form-group\">
                                    <label for=\"exampleInputPassword1\">Phone Number</label>
                                    ";
        // line 60
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 60, $this->source); })()), "phone_number", [], "any", false, false, false, 60), 'widget', ["attr" => ["class" => "form-control"]]);
        echo "
                                </div>
                                <div class=\"col-md-6\">
                                    <div class=\"form-group row\" style=\"display: block;\">
                                        <label class=\"col-sm-3 col-form-label\">Roles</label>
                                        <div class=\"col-sm-2\">
                                            <div class=\"form-check\" style=\"display: flex;\">
                                                ";
        // line 67
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 67, $this->source); })()), "roles", [], "any", false, false, false, 67), 'widget', ["attr" => ["class" => "form-check-input"]]);
        echo "

                                            </div>
                                        </div>

                                    </div>
                                </div>
                                <button type=\"submit\" class=\"btn btn-outline-primary btn-fw\">";
        // line 74
        echo twig_escape_filter($this->env, ((array_key_exists("button_label", $context)) ? (_twig_default_filter((isset($context["button_label"]) || array_key_exists("button_label", $context) ? $context["button_label"] : (function () { throw new RuntimeError('Variable "button_label" does not exist.', 74, $this->source); })()), "Save")) : ("Save")), "html", null, true);
        echo "</button>

                                ";
        // line 76
        echo         $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->renderBlock((isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 76, $this->source); })()), 'form_end');
        echo "

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
        return "user/edit.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  200 => 76,  195 => 74,  185 => 67,  175 => 60,  168 => 56,  161 => 52,  154 => 48,  147 => 44,  141 => 41,  135 => 37,  132 => 36,  126 => 35,  117 => 33,  112 => 32,  107 => 31,  105 => 30,  95 => 23,  91 => 22,  87 => 21,  68 => 4,  58 => 3,  35 => 1,);
    }

    public function getSourceContext()
    {
        return new Source("{% extends 'baseBack.html.twig' %}

    {% block body %}

        <div  class=\"main-panel\">
            <div class=\"content-wrapper\">
                <div class=\"page-header\">
                    <h3 class=\"page-title\"> Profile </h3>

                </div>
                <div class=\"row\">
                    <div class=\"col-md-6 grid-margin stretch-card\">
                        <div class=\"card\">
                            <div class=\"card-body\">

                                <div class=\"row align-items-right\">
                                    <div class=\"col-7\">
                                        <h4 class=\"card-title\">User Information</h4>
                                    </div>
                                    <div class=\"col-4 text-right\" style=\"display: -webkit-box;\">
                                        <a  style=\"margin-left: -23px;\" class=\"btn btn-outline-primary btn-fw\" href=\"{{ path('user_index') }}\">Back</a>
                                        <form style=\" margin-left: 15px;\" method=\"post\" action=\"{{ path('user_delete', {'id': user.id}) }}\" onsubmit=\"return confirm('Are you sure you want to delete this item?');\">
                                            <input type=\"hidden\" name=\"_token\" value=\"{{ csrf_token('delete' ~ user.id) }}\">
                                            <button class=\"btn btn-outline-danger btn-fw\">Delete</button>
                                        </form>
                                    </div>
                                </div>
                                <div class=\"row align-items-center\">
                                    <div class=\"col-12\">
                                        {% if not form.vars.valid %}
                                            {% for child in  form.children %}
                                                {% for error in child.vars.errors %}
                                                    <div class=\"alert alert-danger\">{{ error.message }}</div>
                                                {% endfor %}
                                            {% endfor %}
                                        {% endif %}
                                    </div>
                                </div>

                                <p class=\"card-description\">  </p>
                                {{ form_start(form ) }}
                                <div class=\"form-group\">
                                    <label for=\"exampleInputUsername1\">Email</label>
                                    {{ form_widget(form.email , {'attr' : {'class' : 'form-control' }}) }}
                                </div>
                                <div class=\"form-group\">
                                    <label for=\"exampleInputPassword1\">Username</label>
                                    {{ form_widget(form.usertag , {'attr' : {'class' : 'form-control' }}) }}
                                </div>
                                <div class=\"form-group\">
                                    <label >First name</label>
                                    {{ form_widget(form.firstname , {'attr' : {'class' : 'form-control' }}) }}
                                </div>
                                <div class=\"form-group\">
                                    <label for=\"exampleInputPassword1\">last name</label>
                                    {{ form_widget(form.lastname , {'attr' : {'class' : 'form-control' }}) }}
                                </div>
                                <div class=\"form-group\">
                                    <label for=\"exampleInputPassword1\">Phone Number</label>
                                    {{ form_widget(form.phone_number , {'attr' : {'class' : 'form-control' }}) }}
                                </div>
                                <div class=\"col-md-6\">
                                    <div class=\"form-group row\" style=\"display: block;\">
                                        <label class=\"col-sm-3 col-form-label\">Roles</label>
                                        <div class=\"col-sm-2\">
                                            <div class=\"form-check\" style=\"display: flex;\">
                                                {{ form_widget(form.roles, {'attr' : {'class' : 'form-check-input' }}) }}

                                            </div>
                                        </div>

                                    </div>
                                </div>
                                <button type=\"submit\" class=\"btn btn-outline-primary btn-fw\">{{ button_label|default('Save') }}</button>

                                {{ form_end(form) }}

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    {% endblock %}




", "user/edit.html.twig", "C:\\Users\\Yassine\\Desktop\\gamex_login\\templates\\user\\edit.html.twig");
    }
}
