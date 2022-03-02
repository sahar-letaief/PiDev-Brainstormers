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

/* user/profile_edit.html.twig */
class __TwigTemplate_f29451ac4e4af9ceaa2747eef8edbaf712fed5a4f818ad6e295616da0db937f2 extends Template
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
        return "baseFront.html.twig";
    }

    protected function doDisplay(array $context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "user/profile_edit.html.twig"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "user/profile_edit.html.twig"));

        $this->parent = $this->loadTemplate("baseFront.html.twig", "user/profile_edit.html.twig", 1);
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
        echo "        <section class=\"login spad\">
            <div class=\"container\">
                <div class=\"row\">
                    <div class=\"col-lg-6\">

                        <div class=\"login__form\">
                            <h3>Login</h3>
                            ";
        // line 11
        if ( !twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 11, $this->source); })()), "vars", [], "any", false, false, false, 11), "valid", [], "any", false, false, false, 11)) {
            // line 12
            echo "                                ";
            $context['_parent'] = $context;
            $context['_seq'] = twig_ensure_traversable(twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 12, $this->source); })()), "children", [], "any", false, false, false, 12));
            foreach ($context['_seq'] as $context["_key"] => $context["child"]) {
                // line 13
                echo "                                    ";
                $context['_parent'] = $context;
                $context['_seq'] = twig_ensure_traversable(twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, $context["child"], "vars", [], "any", false, false, false, 13), "errors", [], "any", false, false, false, 13));
                foreach ($context['_seq'] as $context["_key"] => $context["error"]) {
                    // line 14
                    echo "                                        <div class=\"alert alert-danger\">";
                    echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, $context["error"], "message", [], "any", false, false, false, 14), "html", null, true);
                    echo "</div>
                                    ";
                }
                $_parent = $context['_parent'];
                unset($context['_seq'], $context['_iterated'], $context['_key'], $context['error'], $context['_parent'], $context['loop']);
                $context = array_intersect_key($context, $_parent) + $_parent;
                // line 16
                echo "                                ";
            }
            $_parent = $context['_parent'];
            unset($context['_seq'], $context['_iterated'], $context['_key'], $context['child'], $context['_parent'], $context['loop']);
            $context = array_intersect_key($context, $_parent) + $_parent;
            // line 17
            echo "                            ";
        }
        // line 18
        echo "                            ";
        echo         $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->renderBlock((isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 18, $this->source); })()), 'form_start', ["attr" => ["novalidate" => "novalidate"]]);
        echo "
                            <div class=\"input__item\">
                                ";
        // line 20
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 20, $this->source); })()), "email", [], "any", false, false, false, 20), 'widget', ["attr" => ["class" => "form-control"]]);
        echo "
                                <span class=\"icon_mail\"></span>
                            </div>
                            <div class=\"input__item\">
                                ";
        // line 24
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 24, $this->source); })()), "usertag", [], "any", false, false, false, 24), 'widget', ["attr" => ["class" => "form-control"]]);
        echo "
                                <span class=\"icon_profile\"></span>
                            </div>
                            <div class=\"input__item\">
                                ";
        // line 28
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 28, $this->source); })()), "firstname", [], "any", false, false, false, 28), 'widget', ["attr" => ["class" => "form-control"]]);
        echo "
                                <span class=\"icon_profile\"></span>
                            </div>
                            <div class=\"input__item\">
                                ";
        // line 32
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 32, $this->source); })()), "lastname", [], "any", false, false, false, 32), 'widget', ["attr" => ["class" => "form-control"]]);
        echo "
                                <span class=\"icon_profile\"></span>
                            </div>
                            <div class=\"input__item\">
                                ";
        // line 36
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 36, $this->source); })()), "phone_number", [], "any", false, false, false, 36), 'widget', ["attr" => ["class" => "form-control"]]);
        echo "
                                <span class=\"icon_mobile\"></span>
                            </div>


                            <ul>
                                <li><button style=\"background-color: #ff4343;border-radius: 4px;color: #ffffff; display: block;font-size: 13px;font-weight: 700;letter-spacing: 2px;text-transform: uppercase;width: 460px;padding: 14px 0;position: relative;margin: 0 auto; \" type=\"submit\" class=\"btn btn-danger btn-fw\">";
        // line 42
        echo twig_escape_filter($this->env, ((array_key_exists("button_label", $context)) ? (_twig_default_filter((isset($context["button_label"]) || array_key_exists("button_label", $context) ? $context["button_label"] : (function () { throw new RuntimeError('Variable "button_label" does not exist.', 42, $this->source); })()), "Save")) : ("Save")), "html", null, true);
        echo "</button></li>
                            </ul>
                                ";
        // line 44
        echo         $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->renderBlock((isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 44, $this->source); })()), 'form_end');
        echo "
                        </div>
                    </div>
                    <div class=\"col-lg-6\">
                        <div style=\"display: grid\" class=\"login__register\">
                            <h3>Dont’t Have An Account?</h3>
                            <a  class=\"primary-btn\" href=\"";
        // line 50
        echo $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("edit_profile_password");
        echo "\">Edit Password</a>
                            <a  class=\"primary-btn\" href=\"";
        // line 51
        echo $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("profile");
        echo "\">Back</a>
                            <form  method=\"post\" action=\"";
        // line 52
        echo $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("delete_profile");
        echo "\" onsubmit=\"return confirm('Are you sure you want to delete this item?');\">
                                <input type=\"hidden\" name=\"_token\" value=\"";
        // line 53
        echo twig_escape_filter($this->env, $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->renderCsrfToken(("delete" . twig_get_attribute($this->env, $this->source, (isset($context["user"]) || array_key_exists("user", $context) ? $context["user"] : (function () { throw new RuntimeError('Variable "user" does not exist.', 53, $this->source); })()), "id", [], "any", false, false, false, 53))), "html", null, true);
        echo "\">
                                <button  style=\"border: none;\" class=\"primary-btn\">Delete Account</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    ";
        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

    }

    public function getTemplateName()
    {
        return "user/profile_edit.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  176 => 53,  172 => 52,  168 => 51,  164 => 50,  155 => 44,  150 => 42,  141 => 36,  134 => 32,  127 => 28,  120 => 24,  113 => 20,  107 => 18,  104 => 17,  98 => 16,  89 => 14,  84 => 13,  79 => 12,  77 => 11,  68 => 4,  58 => 3,  35 => 1,);
    }

    public function getSourceContext()
    {
        return new Source("{% extends 'baseFront.html.twig' %}

    {% block body %}
        <section class=\"login spad\">
            <div class=\"container\">
                <div class=\"row\">
                    <div class=\"col-lg-6\">

                        <div class=\"login__form\">
                            <h3>Login</h3>
                            {% if not form.vars.valid %}
                                {% for child in  form.children %}
                                    {% for error in child.vars.errors %}
                                        <div class=\"alert alert-danger\">{{ error.message }}</div>
                                    {% endfor %}
                                {% endfor %}
                            {% endif %}
                            {{ form_start(form ,  {'attr' : {'novalidate' : 'novalidate'}}) }}
                            <div class=\"input__item\">
                                {{ form_widget(form.email , {'attr' : {'class' : 'form-control' }}) }}
                                <span class=\"icon_mail\"></span>
                            </div>
                            <div class=\"input__item\">
                                {{ form_widget(form.usertag , {'attr' : {'class' : 'form-control' }}) }}
                                <span class=\"icon_profile\"></span>
                            </div>
                            <div class=\"input__item\">
                                {{ form_widget(form.firstname , {'attr' : {'class' : 'form-control' }}) }}
                                <span class=\"icon_profile\"></span>
                            </div>
                            <div class=\"input__item\">
                                {{ form_widget(form.lastname , {'attr' : {'class' : 'form-control' }}) }}
                                <span class=\"icon_profile\"></span>
                            </div>
                            <div class=\"input__item\">
                                {{ form_widget(form.phone_number , {'attr' : {'class' : 'form-control' }}) }}
                                <span class=\"icon_mobile\"></span>
                            </div>


                            <ul>
                                <li><button style=\"background-color: #ff4343;border-radius: 4px;color: #ffffff; display: block;font-size: 13px;font-weight: 700;letter-spacing: 2px;text-transform: uppercase;width: 460px;padding: 14px 0;position: relative;margin: 0 auto; \" type=\"submit\" class=\"btn btn-danger btn-fw\">{{ button_label|default('Save') }}</button></li>
                            </ul>
                                {{ form_end(form) }}
                        </div>
                    </div>
                    <div class=\"col-lg-6\">
                        <div style=\"display: grid\" class=\"login__register\">
                            <h3>Dont’t Have An Account?</h3>
                            <a  class=\"primary-btn\" href=\"{{ path('edit_profile_password') }}\">Edit Password</a>
                            <a  class=\"primary-btn\" href=\"{{ path('profile') }}\">Back</a>
                            <form  method=\"post\" action=\"{{ path('delete_profile') }}\" onsubmit=\"return confirm('Are you sure you want to delete this item?');\">
                                <input type=\"hidden\" name=\"_token\" value=\"{{ csrf_token('delete' ~ user.id) }}\">
                                <button  style=\"border: none;\" class=\"primary-btn\">Delete Account</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    {% endblock %}




", "user/profile_edit.html.twig", "C:\\Users\\Yassine\\Desktop\\git-login-symfony\\templates\\user\\profile_edit.html.twig");
    }
}
