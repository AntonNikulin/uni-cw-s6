from django.conf.urls import patterns, include, url

urlpatterns = patterns('',
                        url(r'^table/$', 'Checkpoint.views.table', name='table'),
)