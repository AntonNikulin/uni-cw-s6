from django import forms
from .models import Record

class RegistrationForm(forms.Form):
    username = forms.CharField(label=u'Username', max_length=30)
    email = forms.EmailField(label=u'Email')
    password1 = forms.CharField( label=u'Password', widget=forms.PasswordInput() )
    password2 = forms.CharField( label=u'Password (Again)', widget=forms.PasswordInput() )

    def clean_password2(self):
        if 'password1' in self.cleaned_data:
            password1 = self.cleaned_data['password1']
            password2 = self.cleaned_data['password2']
            if password2 == password1:
                return password2
        raise forms.ValidationError('Passwords do not match.')


class RecordForm(forms.ModelForm):
    class Meta:
        model = Record
        exclude = ['recordedBy','destination']

TYPES = (
    ('driver','Driver'),
    ('vehicleNumber','VehicleNumber'),
)
DATES = (
    (1, '1 day'),
    (7, '7 days')
)
class SearchForm(forms.Form):
    search = forms.CharField(label=u'Search: ',max_length=40)
    type = forms.ChoiceField(choices=TYPES)
    date = forms.ChoiceField(choices=DATES)

