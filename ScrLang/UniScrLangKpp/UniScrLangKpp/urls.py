from django.conf.urls import patterns, include, url
from Checkpoint import views

# Uncomment the next two lines to enable the admin:
# from django.contrib import admin
# admin.autodiscover()

urlpatterns = patterns('',
                        #authentication
                        url(r"^login/$", "django.contrib.auth.views.login", {"template_name": "registration/login.html"}, name="login"),
                        url(r"^logout/$", "django.contrib.auth.views.logout", {"next_page": "/"}, name= "logout"),
                        url(r"^register/$", "Checkpoint.views.registrationPage", name="registration"),

                        #custom
                        url(r'^$', 'Checkpoint.views.Index', name='Index'),

    # Examples:
    # url(r'^$', 'UniScrLangKpp.views.home', name='home'),
    # url(r'^UniScrLangKpp/', include('UniScrLangKpp.foo.urls')),

    # Uncomment the admin/doc line below to enable admin documentation:
    # url(r'^admin/doc/', include('django.contrib.admindocs.urls')),

    # Uncomment the next line to enable the admin:
    # url(r'^admin/', include(admin.site.urls)),
)
