from django.conf.urls import patterns, include, url
from Checkpoint import views

# Uncomment the next two lines to enable the admin:
# from django.contrib import admin
# admin.autodiscover()

urlpatterns = patterns('',
                       url(r'^$', 'Checkpoint.views.Index', name='Index'),
    # Examples:
    # url(r'^$', 'UniScrLangKpp.views.home', name='home'),
    # url(r'^UniScrLangKpp/', include('UniScrLangKpp.foo.urls')),

    # Uncomment the admin/doc line below to enable admin documentation:
    # url(r'^admin/doc/', include('django.contrib.admindocs.urls')),

    # Uncomment the next line to enable the admin:
    # url(r'^admin/', include(admin.site.urls)),
)