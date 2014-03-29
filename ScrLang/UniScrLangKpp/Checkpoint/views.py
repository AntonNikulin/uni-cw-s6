from django.shortcuts import render, get_object_or_404, HttpResponseRedirect

def Index(request):
    return render(request, 'base.html')
