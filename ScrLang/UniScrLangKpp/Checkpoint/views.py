import datetime

from django.shortcuts import render
from django.contrib.auth.models import User
from django.contrib.auth.decorators import login_required
from django.core.urlresolvers import reverse
from django.http import HttpResponseRedirect

from forms import *
from .models import Record


def Index(request):
    return render(request, 'Checkpoint/index.html')

def contacts(request):
    return render(request, 'Checkpoint/contacts.html')

def registrationPage(request):
    if request.method == 'POST':
        form = RegistrationForm(request.POST)
        if form.is_valid():
            user = User.objects.create_user(
                username = form.cleaned_data['username'],
                password = form.cleaned_data['password1'],
                email = form.cleaned_data['email']
            )
            return HttpResponseRedirect('/')
        return render( request, 'registration/register.html', {'form': form,} )
    else:
        form = RegistrationForm()
        return render( request, 'registration/register.html', {'form': form,} )

def table(request):
    Records = Record.objects.all()
    return render(request, 'Checkpoint/table.html', {'Records': Records})

def searchDriver(request):
    if request.method == 'POST':
        Records = Record.objects.filter(driver__icontains = request.POST['driver'])
        count = len(Records)
        return render(request, 'Checkpoint/table.html', {'Records': Records,
                                                         'count': count})

def searchVehicle(request):
    if request.method == 'POST':
        Records = Record.objects.filter(vehicleNumber__icontains = request.POST['driver'])
        count = len(Records)
        return render(request, 'Checkpoint/table.html', {'Records': Records,
                                                         'count': count})

def search(request):
    if request.method == 'POST':
        Records = None
        if request.POST['type'] == 'driver' and request.POST['date'] == '1':
            Records = Record.objects.filter(driver__icontains = request.POST['search'])\
                                            .exclude(time__lt=datetime.date.today())
        if request.POST['type'] == 'driver' and request.POST['date'] == '7':
            Records = Record.objects.filter(driver__icontains = request.POST['search'])\
                                            .exclude(time__lt=datetime.date.today()-datetime.timedelta(days=7))

        if request.POST['type'] == 'vehicleNumber' and request.POST['date'] == '1':
            Records = Record.objects.filter(vehicleNumber__icontains = request.POST['search'])\
                                                        .exclude(time__lt=datetime.date.today())
        if request.POST['type'] == 'vehicleNumber' and request.POST['date'] == '7':
            Records = Record.objects.filter(vehicleNumber__icontains = request.POST['search'])\
                                                        .exclude(time__lt=datetime.date.today()-datetime.timedelta(days=7))


        return render(request, 'Checkpoint/table.html', {'Records': Records,
                                                         'count': len(Records)})
    form = SearchForm()
    return render(request, 'Checkpoint/search_main.html', {'form': form})

def statistics(request):
    driverCount = {}
    Records = Record.objects.all()
    for rec in Records:
        if rec.driver not in driverCount:
            driverCount[rec.driver] = 1
        else:
            driverCount[rec.driver] += 1
    return render(request, 'Checkpoint/Statistics.html', {'driverCount': driverCount})

@login_required
def recordCreate(request):
    if request.method == 'POST':
        form = RecordForm(request.POST)
        if form.is_valid():
            record = Record.objects.create(
                vehicleNumber = form.cleaned_data['vehicleNumber'],
                driver = form.cleaned_data['driver'],
                cargo = form.cleaned_data['cargo'],
                recordedBy = request.user
            )
            return HttpResponseRedirect(reverse('table'))
        return render(request, 'Checkpoint/record_create_form.html', {'form': form})
    else:
        form = RecordForm()
        return render(request, 'Checkpoint/record_create_form.html', {'form': form})

@login_required
def recordDelete(request, id):
    Record.objects.get(pk=id).delete()
    return HttpResponseRedirect(reverse('table'))
