/*****************************code to convert check box to radio and vice versa on single/multi******************/
$(function(){
		$('input[type=radio][name=Qtype]').change(function() {
			    if (this.value == '1') {
			    	$('input[type=checkbox][name=radios]').each(function(){
			    	    $(this).prop("type","radio");
			    	});
			        
			    }
			    else if (this.value == '2') {
			    	$('input[type=radio][name=radios]').each(function(){
			    	    $(this).prop("type","checkbox");
			    	});
			    }
			});
		});