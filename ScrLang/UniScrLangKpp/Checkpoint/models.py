from django.db import models
from django.contrib.auth.models import User

# -*- coding: utf-8 -*-

class Record(models.Model):
    vehicleNumber = models.CharField(max_length=50, blank=False)
    driver = models.CharField(max_length=50, blank=True)
    destination = models.CharField(max_length=50, blank=True)
    cargo = models.CharField(max_length=50, blank=True)
    time = models.DateTimeField(auto_now_add=True)
    recordedBy = models.ForeignKey(User, null=True, blank=True)

