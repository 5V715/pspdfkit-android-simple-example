package com.pspdfkit.example;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;

import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.ui.PdfActivity;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.annotations.OnAnnotationSelectedListener;
import com.pspdfkit.ui.special_mode.controller.AnnotationSelectionController;

public class SampleActivity extends PdfActivity {

    private static final class Listener implements OnAnnotationSelectedListener {
        @Override
        public boolean onPrepareAnnotationSelection(AnnotationSelectionController controller, Annotation annotation, boolean annotationCreated) {
            return annotation.getType() != AnnotationType.HIGHLIGHT;
        }
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        PdfFragment pdfFragment = (PdfFragment) getSupportFragmentManager().findFragmentById(com.pspdfkit.R.id.pspdf__activity_fragment_container);
        if(pdfFragment != null) {
            pdfFragment.addOnAnnotationSelectedListener(new Listener());
        }
    }

}
