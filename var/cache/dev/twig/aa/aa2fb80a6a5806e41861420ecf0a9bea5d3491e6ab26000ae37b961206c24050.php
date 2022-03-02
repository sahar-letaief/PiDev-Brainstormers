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

/* user/profile.html.twig */
class __TwigTemplate_46324552ce353c866181a066a4f09f4f6b7ccb3b6e30c4d83e439d28897f64ad extends Template
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
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "user/profile.html.twig"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "user/profile.html.twig"));

        $this->parent = $this->loadTemplate("baseFront.html.twig", "user/profile.html.twig", 1);
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
    <!-- Breadcrumb Begin -->
    <div class=\"breadcrumb-option\">
        <div class=\"container\">
            <div class=\"row\">
                <div class=\"col-lg-12\">
                    <div class=\"breadcrumb__links\">
                        <a href=\"./index.html\"><i class=\"fa fa-home\"></i> Home</a>
                        <a href=\"./categories.html\">Profile</a>
                        <span>Display</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->

<section class=\"anime-details spad\">
    <div class=\"container\">
        <div class=\"anime__details__content\">
            <div class=\"row\">
                <div class=\"col-lg-3\">
                    <div class=\"anime__details__pic set-bg\" data-setbg=\"img/anime/details-pic.jpg\">
                        <div class=\"comment\"><i class=\"fa fa-comments\"></i> 11</div>
                        <div class=\"view\"><i class=\"fa fa-eye\"></i> 9141</div>
                    </div>
                </div>
                <div class=\"col-lg-9\">
                    <div class=\"anime__details__text\">
                        <div class=\"anime__details__title\">
                            <h3>USER PROFILE</h3>
                        </div>

                        <p>Welcome ";
        // line 37
        echo twig_escape_filter($this->env, ((twig_get_attribute($this->env, $this->source, (isset($context["user"]) || array_key_exists("user", $context) ? $context["user"] : (function () { throw new RuntimeError('Variable "user" does not exist.', 37, $this->source); })()), "firstname", [], "any", false, false, false, 37) . " ") . twig_get_attribute($this->env, $this->source, (isset($context["user"]) || array_key_exists("user", $context) ? $context["user"] : (function () { throw new RuntimeError('Variable "user" does not exist.', 37, $this->source); })()), "lastname", [], "any", false, false, false, 37)), "html", null, true);
        echo " </p>
                        <p> only you have access to this page to have acces to your private data to edit or mkae any change to them , disable your account or even delete it permanently</p>
                        <div class=\"anime__details__widget\">
                            <div class=\"row\">
                                <div class=\"col-lg-6 col-md-6\">
                                    <ul>
                                        <li><span>Email :</span>";
        // line 43
        echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, (isset($context["user"]) || array_key_exists("user", $context) ? $context["user"] : (function () { throw new RuntimeError('Variable "user" does not exist.', 43, $this->source); })()), "email", [], "any", false, false, false, 43), "html", null, true);
        echo "</li>
                                        <li><span>First name :</span>";
        // line 44
        echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, (isset($context["user"]) || array_key_exists("user", $context) ? $context["user"] : (function () { throw new RuntimeError('Variable "user" does not exist.', 44, $this->source); })()), "firstname", [], "any", false, false, false, 44), "html", null, true);
        echo "</li>
                                        <li><span>Last name :</span> ";
        // line 45
        echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, (isset($context["user"]) || array_key_exists("user", $context) ? $context["user"] : (function () { throw new RuntimeError('Variable "user" does not exist.', 45, $this->source); })()), "lastname", [], "any", false, false, false, 45), "html", null, true);
        echo "</li>
                                        <li><span>Phone Number:</span> ";
        // line 46
        echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, (isset($context["user"]) || array_key_exists("user", $context) ? $context["user"] : (function () { throw new RuntimeError('Variable "user" does not exist.', 46, $this->source); })()), "phonenumber", [], "any", false, false, false, 46), "html", null, true);
        echo "</li>
                                        <li><span>Username:</span> ";
        // line 47
        echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, (isset($context["user"]) || array_key_exists("user", $context) ? $context["user"] : (function () { throw new RuntimeError('Variable "user" does not exist.', 47, $this->source); })()), "usertag", [], "any", false, false, false, 47), "html", null, true);
        echo "</li>
                                    </ul>
                                </div>
                                <div class=\"col-lg-6 col-md-6\">
                                    <div class=\"anime__details__btn\" style=\"display: flex\">
                                        <a class=\"follow-btn\" href=\"";
        // line 52
        echo $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("edit_profile");
        echo "\"><span> edit </span><i
                                                    class=\"fa fa-angle-right\"></i></a>
                                        <form  method=\"post\" action=\"";
        // line 54
        echo $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("delete_profile");
        echo "\" onsubmit=\"return confirm('Are you sure you want to delete this item?');\">
                                            <input type=\"hidden\" name=\"_token\" value=\"";
        // line 55
        echo twig_escape_filter($this->env, $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->renderCsrfToken(("delete" . twig_get_attribute($this->env, $this->source, (isset($context["user"]) || array_key_exists("user", $context) ? $context["user"] : (function () { throw new RuntimeError('Variable "user" does not exist.', 55, $this->source); })()), "id", [], "any", false, false, false, 55))), "html", null, true);
        echo "\">
                                            <button style=\"width: 200px;background: #e53637;border-radius: 4px;color: #ffffff; display: block;font-size: 13px;font-weight: 700;letter-spacing: 2px;text-transform: uppercase;padding: 14px 0;position: relative;margin: 0 auto; \" class=\"btn btn-danger btn-fw\"><i
                                                        class=\"fa fa-angle-right\"></i> Delete Account</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
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
        return "user/profile.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  145 => 55,  141 => 54,  136 => 52,  128 => 47,  124 => 46,  120 => 45,  116 => 44,  112 => 43,  103 => 37,  68 => 4,  58 => 3,  35 => 1,);
    }

    public function getSourceContext()
    {
        return new Source("{% extends 'baseFront.html.twig' %}

{% block body %}

    <!-- Breadcrumb Begin -->
    <div class=\"breadcrumb-option\">
        <div class=\"container\">
            <div class=\"row\">
                <div class=\"col-lg-12\">
                    <div class=\"breadcrumb__links\">
                        <a href=\"./index.html\"><i class=\"fa fa-home\"></i> Home</a>
                        <a href=\"./categories.html\">Profile</a>
                        <span>Display</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->

<section class=\"anime-details spad\">
    <div class=\"container\">
        <div class=\"anime__details__content\">
            <div class=\"row\">
                <div class=\"col-lg-3\">
                    <div class=\"anime__details__pic set-bg\" data-setbg=\"img/anime/details-pic.jpg\">
                        <div class=\"comment\"><i class=\"fa fa-comments\"></i> 11</div>
                        <div class=\"view\"><i class=\"fa fa-eye\"></i> 9141</div>
                    </div>
                </div>
                <div class=\"col-lg-9\">
                    <div class=\"anime__details__text\">
                        <div class=\"anime__details__title\">
                            <h3>USER PROFILE</h3>
                        </div>

                        <p>Welcome {{ user.firstname ~ ' ' ~user.lastname}} </p>
                        <p> only you have access to this page to have acces to your private data to edit or mkae any change to them , disable your account or even delete it permanently</p>
                        <div class=\"anime__details__widget\">
                            <div class=\"row\">
                                <div class=\"col-lg-6 col-md-6\">
                                    <ul>
                                        <li><span>Email :</span>{{ user.email }}</li>
                                        <li><span>First name :</span>{{ user.firstname }}</li>
                                        <li><span>Last name :</span> {{ user.lastname }}</li>
                                        <li><span>Phone Number:</span> {{ user.phonenumber }}</li>
                                        <li><span>Username:</span> {{ user.usertag }}</li>
                                    </ul>
                                </div>
                                <div class=\"col-lg-6 col-md-6\">
                                    <div class=\"anime__details__btn\" style=\"display: flex\">
                                        <a class=\"follow-btn\" href=\"{{ path('edit_profile') }}\"><span> edit </span><i
                                                    class=\"fa fa-angle-right\"></i></a>
                                        <form  method=\"post\" action=\"{{ path('delete_profile') }}\" onsubmit=\"return confirm('Are you sure you want to delete this item?');\">
                                            <input type=\"hidden\" name=\"_token\" value=\"{{ csrf_token('delete' ~ user.id) }}\">
                                            <button style=\"width: 200px;background: #e53637;border-radius: 4px;color: #ffffff; display: block;font-size: 13px;font-weight: 700;letter-spacing: 2px;text-transform: uppercase;padding: 14px 0;position: relative;margin: 0 auto; \" class=\"btn btn-danger btn-fw\"><i
                                                        class=\"fa fa-angle-right\"></i> Delete Account</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
{% endblock %}
", "user/profile.html.twig", "C:\\Users\\Yassine\\Desktop\\git-login-symfony\\templates\\user\\profile.html.twig");
    }
}
