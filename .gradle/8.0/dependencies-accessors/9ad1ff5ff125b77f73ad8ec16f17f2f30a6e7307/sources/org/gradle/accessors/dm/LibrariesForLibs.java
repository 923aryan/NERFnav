package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the `libs` extension.
*/
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final AndroidLibraryAccessors laccForAndroidLibraryAccessors = new AndroidLibraryAccessors(owner);
    private final AndroidxLibraryAccessors laccForAndroidxLibraryAccessors = new AndroidxLibraryAccessors(owner);
    private final DokkaLibraryAccessors laccForDokkaLibraryAccessors = new DokkaLibraryAccessors(owner);
    private final JacocoLibraryAccessors laccForJacocoLibraryAccessors = new JacocoLibraryAccessors(owner);
    private final KotlinLibraryAccessors laccForKotlinLibraryAccessors = new KotlinLibraryAccessors(owner);
    private final MapsLibraryAccessors laccForMapsLibraryAccessors = new MapsLibraryAccessors(owner);
    private final PoiLibraryAccessors laccForPoiLibraryAccessors = new PoiLibraryAccessors(owner);
    private final TestLibraryAccessors laccForTestLibraryAccessors = new TestLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

        /**
         * Creates a dependency provider for coroutines (org.jetbrains.kotlinx:kotlinx-coroutines-test)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCoroutines() { return create("coroutines"); }

        /**
         * Creates a dependency provider for material (com.google.android.material:material)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getMaterial() { return create("material"); }

        /**
         * Creates a dependency provider for ycharts (co.yml:ycharts)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getYcharts() { return create("ycharts"); }

    /**
     * Returns the group of libraries at android
     */
    public AndroidLibraryAccessors getAndroid() { return laccForAndroidLibraryAccessors; }

    /**
     * Returns the group of libraries at androidx
     */
    public AndroidxLibraryAccessors getAndroidx() { return laccForAndroidxLibraryAccessors; }

    /**
     * Returns the group of libraries at dokka
     */
    public DokkaLibraryAccessors getDokka() { return laccForDokkaLibraryAccessors; }

    /**
     * Returns the group of libraries at jacoco
     */
    public JacocoLibraryAccessors getJacoco() { return laccForJacocoLibraryAccessors; }

    /**
     * Returns the group of libraries at kotlin
     */
    public KotlinLibraryAccessors getKotlin() { return laccForKotlinLibraryAccessors; }

    /**
     * Returns the group of libraries at maps
     */
    public MapsLibraryAccessors getMaps() { return laccForMapsLibraryAccessors; }

    /**
     * Returns the group of libraries at poi
     */
    public PoiLibraryAccessors getPoi() { return laccForPoiLibraryAccessors; }

    /**
     * Returns the group of libraries at test
     */
    public TestLibraryAccessors getTest() { return laccForTestLibraryAccessors; }

    /**
     * Returns the group of versions at versions
     */
    public VersionAccessors getVersions() { return vaccForVersionAccessors; }

    /**
     * Returns the group of bundles at bundles
     */
    public BundleAccessors getBundles() { return baccForBundleAccessors; }

    /**
     * Returns the group of plugins at plugins
     */
    public PluginAccessors getPlugins() { return paccForPluginAccessors; }

    public static class AndroidLibraryAccessors extends SubDependencyFactory {
        private final AndroidGradleLibraryAccessors laccForAndroidGradleLibraryAccessors = new AndroidGradleLibraryAccessors(owner);

        public AndroidLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at android.gradle
         */
        public AndroidGradleLibraryAccessors getGradle() { return laccForAndroidGradleLibraryAccessors; }

    }

    public static class AndroidGradleLibraryAccessors extends SubDependencyFactory {

        public AndroidGradleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for plugin (com.android.tools.build:gradle)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getPlugin() { return create("android.gradle.plugin"); }

    }

    public static class AndroidxLibraryAccessors extends SubDependencyFactory {
        private final AndroidxComposeLibraryAccessors laccForAndroidxComposeLibraryAccessors = new AndroidxComposeLibraryAccessors(owner);
        private final AndroidxMedia3LibraryAccessors laccForAndroidxMedia3LibraryAccessors = new AndroidxMedia3LibraryAccessors(owner);
        private final AndroidxTestLibraryAccessors laccForAndroidxTestLibraryAccessors = new AndroidxTestLibraryAccessors(owner);

        public AndroidxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (androidx.core:core-ktx)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("androidx.core"); }

        /**
         * Returns the group of libraries at androidx.compose
         */
        public AndroidxComposeLibraryAccessors getCompose() { return laccForAndroidxComposeLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.media3
         */
        public AndroidxMedia3LibraryAccessors getMedia3() { return laccForAndroidxMedia3LibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.test
         */
        public AndroidxTestLibraryAccessors getTest() { return laccForAndroidxTestLibraryAccessors; }

    }

    public static class AndroidxComposeLibraryAccessors extends SubDependencyFactory {
        private final AndroidxComposeUiLibraryAccessors laccForAndroidxComposeUiLibraryAccessors = new AndroidxComposeUiLibraryAccessors(owner);

        public AndroidxComposeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for activity (androidx.activity:activity-compose)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getActivity() { return create("androidx.compose.activity"); }

            /**
             * Creates a dependency provider for bom (androidx.compose:compose-bom)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getBom() { return create("androidx.compose.bom"); }

            /**
             * Creates a dependency provider for foundation (androidx.compose.foundation:foundation)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getFoundation() { return create("androidx.compose.foundation"); }

            /**
             * Creates a dependency provider for material (androidx.compose.material:material)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getMaterial() { return create("androidx.compose.material"); }

        /**
         * Returns the group of libraries at androidx.compose.ui
         */
        public AndroidxComposeUiLibraryAccessors getUi() { return laccForAndroidxComposeUiLibraryAccessors; }

    }

    public static class AndroidxComposeUiLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final AndroidxComposeUiPreviewLibraryAccessors laccForAndroidxComposeUiPreviewLibraryAccessors = new AndroidxComposeUiPreviewLibraryAccessors(owner);

        public AndroidxComposeUiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ui (androidx.compose.ui:ui)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() { return create("androidx.compose.ui"); }

            /**
             * Creates a dependency provider for tooling (androidx.compose.ui:ui-tooling)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getTooling() { return create("androidx.compose.ui.tooling"); }

        /**
         * Returns the group of libraries at androidx.compose.ui.preview
         */
        public AndroidxComposeUiPreviewLibraryAccessors getPreview() { return laccForAndroidxComposeUiPreviewLibraryAccessors; }

    }

    public static class AndroidxComposeUiPreviewLibraryAccessors extends SubDependencyFactory {

        public AndroidxComposeUiPreviewLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for tooling (androidx.compose.ui:ui-tooling-preview)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getTooling() { return create("androidx.compose.ui.preview.tooling"); }

    }

    public static class AndroidxMedia3LibraryAccessors extends SubDependencyFactory {
        private final AndroidxMedia3ExoplayerLibraryAccessors laccForAndroidxMedia3ExoplayerLibraryAccessors = new AndroidxMedia3ExoplayerLibraryAccessors(owner);

        public AndroidxMedia3LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ui (androidx.media3:media3-ui)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getUi() { return create("androidx.media3.ui"); }

        /**
         * Returns the group of libraries at androidx.media3.exoplayer
         */
        public AndroidxMedia3ExoplayerLibraryAccessors getExoplayer() { return laccForAndroidxMedia3ExoplayerLibraryAccessors; }

    }

    public static class AndroidxMedia3ExoplayerLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public AndroidxMedia3ExoplayerLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for exoplayer (androidx.media3:media3-exoplayer)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() { return create("androidx.media3.exoplayer"); }

            /**
             * Creates a dependency provider for dash (androidx.media3:media3-exoplayer-dash)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getDash() { return create("androidx.media3.exoplayer.dash"); }

    }

    public static class AndroidxTestLibraryAccessors extends SubDependencyFactory {
        private final AndroidxTestComposeLibraryAccessors laccForAndroidxTestComposeLibraryAccessors = new AndroidxTestComposeLibraryAccessors(owner);
        private final AndroidxTestJunitLibraryAccessors laccForAndroidxTestJunitLibraryAccessors = new AndroidxTestJunitLibraryAccessors(owner);

        public AndroidxTestLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (androidx.test:core)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("androidx.test.core"); }

            /**
             * Creates a dependency provider for espresso (androidx.test.espresso:espresso-core)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getEspresso() { return create("androidx.test.espresso"); }

            /**
             * Creates a dependency provider for rules (androidx.test:rules)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getRules() { return create("androidx.test.rules"); }

            /**
             * Creates a dependency provider for runner (androidx.test:runner)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getRunner() { return create("androidx.test.runner"); }

        /**
         * Returns the group of libraries at androidx.test.compose
         */
        public AndroidxTestComposeLibraryAccessors getCompose() { return laccForAndroidxTestComposeLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.test.junit
         */
        public AndroidxTestJunitLibraryAccessors getJunit() { return laccForAndroidxTestJunitLibraryAccessors; }

    }

    public static class AndroidxTestComposeLibraryAccessors extends SubDependencyFactory {

        public AndroidxTestComposeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ui (androidx.compose.ui:ui-test-junit4)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getUi() { return create("androidx.test.compose.ui"); }

    }

    public static class AndroidxTestJunitLibraryAccessors extends SubDependencyFactory {

        public AndroidxTestJunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ktx (androidx.test.ext:junit-ktx)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKtx() { return create("androidx.test.junit.ktx"); }

    }

    public static class DokkaLibraryAccessors extends SubDependencyFactory {

        public DokkaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for plugin (org.jetbrains.dokka:dokka-gradle-plugin)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getPlugin() { return create("dokka.plugin"); }

    }

    public static class JacocoLibraryAccessors extends SubDependencyFactory {
        private final JacocoAndroidLibraryAccessors laccForJacocoAndroidLibraryAccessors = new JacocoAndroidLibraryAccessors(owner);

        public JacocoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at jacoco.android
         */
        public JacocoAndroidLibraryAccessors getAndroid() { return laccForJacocoAndroidLibraryAccessors; }

    }

    public static class JacocoAndroidLibraryAccessors extends SubDependencyFactory {

        public JacocoAndroidLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for plugin (com.mxalbert.gradle:jacoco-android)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getPlugin() { return create("jacoco.android.plugin"); }

    }

    public static class KotlinLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final KotlinGradleLibraryAccessors laccForKotlinGradleLibraryAccessors = new KotlinGradleLibraryAccessors(owner);

        public KotlinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for kotlin (org.jetbrains.kotlin:kotlin-stdlib-jdk7)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() { return create("kotlin"); }

        /**
         * Returns the group of libraries at kotlin.gradle
         */
        public KotlinGradleLibraryAccessors getGradle() { return laccForKotlinGradleLibraryAccessors; }

    }

    public static class KotlinGradleLibraryAccessors extends SubDependencyFactory {

        public KotlinGradleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for plugin (org.jetbrains.kotlin:kotlin-gradle-plugin)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getPlugin() { return create("kotlin.gradle.plugin"); }

    }

    public static class MapsLibraryAccessors extends SubDependencyFactory {
        private final MapsKtxLibraryAccessors laccForMapsKtxLibraryAccessors = new MapsKtxLibraryAccessors(owner);
        private final MapsSecretsLibraryAccessors laccForMapsSecretsLibraryAccessors = new MapsSecretsLibraryAccessors(owner);

        public MapsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for playservice (com.google.android.gms:play-services-maps)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getPlayservice() { return create("maps.playservice"); }

        /**
         * Returns the group of libraries at maps.ktx
         */
        public MapsKtxLibraryAccessors getKtx() { return laccForMapsKtxLibraryAccessors; }

        /**
         * Returns the group of libraries at maps.secrets
         */
        public MapsSecretsLibraryAccessors getSecrets() { return laccForMapsSecretsLibraryAccessors; }

    }

    public static class MapsKtxLibraryAccessors extends SubDependencyFactory {

        public MapsKtxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for std (com.google.maps.android:maps-ktx)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getStd() { return create("maps.ktx.std"); }

            /**
             * Creates a dependency provider for utils (com.google.maps.android:maps-utils-ktx)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getUtils() { return create("maps.ktx.utils"); }

    }

    public static class MapsSecretsLibraryAccessors extends SubDependencyFactory {

        public MapsSecretsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for plugin (com.google.android.libraries.mapsplatform.secrets-gradle-plugin:secrets-gradle-plugin)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getPlugin() { return create("maps.secrets.plugin"); }

    }

    public static class PoiLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public PoiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for poi (org.apache.poi:poi)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() { return create("poi"); }

            /**
             * Creates a dependency provider for ooxml (org.apache.poi:poi-ooxml)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getOoxml() { return create("poi.ooxml"); }

    }

    public static class TestLibraryAccessors extends SubDependencyFactory {

        public TestLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for junit (junit:junit)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJunit() { return create("test.junit"); }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final ComposeVersionAccessors vaccForComposeVersionAccessors = new ComposeVersionAccessors(providers, config);
        private final JacocoVersionAccessors vaccForJacocoVersionAccessors = new JacocoVersionAccessors(providers, config);
        private final Media3VersionAccessors vaccForMedia3VersionAccessors = new Media3VersionAccessors(providers, config);
        private final PoiVersionAccessors vaccForPoiVersionAccessors = new PoiVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: activitycompose (1.7.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getActivitycompose() { return getVersion("activitycompose"); }

            /**
             * Returns the version associated to this alias: agp (8.1.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAgp() { return getVersion("agp"); }

            /**
             * Returns the version associated to this alias: androidxtest (1.5.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAndroidxtest() { return getVersion("androidxtest"); }

            /**
             * Returns the version associated to this alias: composecompiler (1.5.3)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getComposecompiler() { return getVersion("composecompiler"); }

            /**
             * Returns the version associated to this alias: coroutines (1.6.4)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCoroutines() { return getVersion("coroutines"); }

            /**
             * Returns the version associated to this alias: dokka (1.9.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getDokka() { return getVersion("dokka"); }

            /**
             * Returns the version associated to this alias: espresso (3.5.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getEspresso() { return getVersion("espresso"); }

            /**
             * Returns the version associated to this alias: junit (4.13.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJunit() { return getVersion("junit"); }

            /**
             * Returns the version associated to this alias: junitktx (1.1.5)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJunitktx() { return getVersion("junitktx"); }

            /**
             * Returns the version associated to this alias: kotlin (1.9.10)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKotlin() { return getVersion("kotlin"); }

            /**
             * Returns the version associated to this alias: mapsecrets (2.0.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getMapsecrets() { return getVersion("mapsecrets"); }

            /**
             * Returns the version associated to this alias: mapsktx (4.0.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getMapsktx() { return getVersion("mapsktx"); }

            /**
             * Returns the version associated to this alias: material (1.9.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getMaterial() { return getVersion("material"); }

            /**
             * Returns the version associated to this alias: ycharts (2.1.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getYcharts() { return getVersion("ycharts"); }

        /**
         * Returns the group of versions at versions.compose
         */
        public ComposeVersionAccessors getCompose() { return vaccForComposeVersionAccessors; }

        /**
         * Returns the group of versions at versions.jacoco
         */
        public JacocoVersionAccessors getJacoco() { return vaccForJacocoVersionAccessors; }

        /**
         * Returns the group of versions at versions.media3
         */
        public Media3VersionAccessors getMedia3() { return vaccForMedia3VersionAccessors; }

        /**
         * Returns the group of versions at versions.poi
         */
        public PoiVersionAccessors getPoi() { return vaccForPoiVersionAccessors; }

    }

    public static class ComposeVersionAccessors extends VersionFactory  {

        public ComposeVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: compose.bom (2023.09.01)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getBom() { return getVersion("compose.bom"); }

    }

    public static class JacocoVersionAccessors extends VersionFactory  {

        private final JacocoToolVersionAccessors vaccForJacocoToolVersionAccessors = new JacocoToolVersionAccessors(providers, config);
        public JacocoVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: jacoco.plugin (0.2.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getPlugin() { return getVersion("jacoco.plugin"); }

        /**
         * Returns the group of versions at versions.jacoco.tool
         */
        public JacocoToolVersionAccessors getTool() { return vaccForJacocoToolVersionAccessors; }

    }

    public static class JacocoToolVersionAccessors extends VersionFactory  {

        public JacocoToolVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: jacoco.tool.plugin (0.8.7)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getPlugin() { return getVersion("jacoco.tool.plugin"); }

    }

    public static class Media3VersionAccessors extends VersionFactory  {

        private final Media3ExoplayerVersionAccessors vaccForMedia3ExoplayerVersionAccessors = new Media3ExoplayerVersionAccessors(providers, config);
        public Media3VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: media3.ui (1.1.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getUi() { return getVersion("media3.ui"); }

        /**
         * Returns the group of versions at versions.media3.exoplayer
         */
        public Media3ExoplayerVersionAccessors getExoplayer() { return vaccForMedia3ExoplayerVersionAccessors; }

    }

    public static class Media3ExoplayerVersionAccessors extends VersionFactory  implements VersionNotationSupplier {

        public Media3ExoplayerVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the version associated to this alias: media3.exoplayer (1.1.1)
         * If the version is a rich version and that its not expressible as a
         * single version string, then an empty string is returned.
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> asProvider() { return getVersion("media3.exoplayer"); }

            /**
             * Returns the version associated to this alias: media3.exoplayer.dash (1.1.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getDash() { return getVersion("media3.exoplayer.dash"); }

    }

    public static class PoiVersionAccessors extends VersionFactory  implements VersionNotationSupplier {

        public PoiVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the version associated to this alias: poi (5.2.2)
         * If the version is a rich version and that its not expressible as a
         * single version string, then an empty string is returned.
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> asProvider() { return getVersion("poi"); }

            /**
             * Returns the version associated to this alias: poi.ooxml (5.2.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getOoxml() { return getVersion("poi.ooxml"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for dokka to the plugin id 'org.jetbrains.dokka'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getDokka() { return createPlugin("dokka"); }

    }

}
