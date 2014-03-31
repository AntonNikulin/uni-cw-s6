from django.conf.urls import patterns, include, url
from Checkpoint import views

# Uncomment the next two lines to enable the admin:
# from django.contrib import admin
# admin.autodiscover()

urlpatterns = patterns('',
                       #Checkpoint
                       url(r'^checkpoint/', include("Checkpoint.urls")),

                       #authentication
                       url(r"^login/$", "django.contrib.auth.views.login", {"template_name": "registration/login.html"}, name="login"),
                       url(r"^logout/$", "django.contrib.auth.views.logout", {"next_page": "/"}, name= "logout"),
                       url(r"^register/$", "Checkpoint.views.registrationPage", name="registration"),

                       #Hit home
                       url(r'^$', 'Checkpoint.views.Index', name='Index'),

)
