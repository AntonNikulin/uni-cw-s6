from django.conf.urls import patterns, include, url

urlpatterns = patterns('',
                        url(r'^table/$', 'Checkpoint.views.table', name='table'),
                        url(r'^record/create/$', 'Checkpoint.views.recordCreate', name='createRecord'),
                        url(r'record/delete/(?P<id>\d+)', 'Checkpoint.views.recordDelete', name='recordDelete'),
                        url(r'search$', 'Checkpoint.views.search', name='search'),
                        url(r'search/driver$', 'Checkpoint.views.searchDriver', name='searchDriver'),
                        url(r'search/vehicle$', 'Checkpoint.views.searchVehicle', name='searchVehicle'),
                        url(r'statistics$', 'Checkpoint.views.statistics', name='statistics'),
                        url(r'contacts/$', 'Checkpoint.views.contacts', name='contacts'),
)