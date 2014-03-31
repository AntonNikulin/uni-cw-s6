from django.db import models

# -*- coding: utf-8 -*-

class Person(models.Model):
    firstName = models.CharField(max_length=50, blank=False)
    lastName = models.CharField(max_length=50, blank=True)
    country = models.CharField(max_length=50, blank=True)

    def __unicode__(self):
        return self.firstName




class Vehicle(models.Model):
    Number = models.CharField(max_length=50, blank=False)
    Driver = models.ForeignKey(Person, blank=True, null=True, on_delete=models.SET_NULL)

    def __unicode__(self):
        return self.Number


class Record(models.Model):
    vehicle = models.ForeignKey(Vehicle, blank=True, null=True, on_delete=models.SET_NULL)
    description = models.TextField(max_length=1000, blank=True, null=True)
