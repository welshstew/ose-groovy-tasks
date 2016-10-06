import io.fabric8.kubernetes.api.model.HostPathVolumeSource
import io.fabric8.kubernetes.api.model.KubernetesList
import io.fabric8.kubernetes.api.model.KubernetesListBuilder
import io.fabric8.kubernetes.api.model.Quantity
import io.fabric8.kubernetes.generator.annotation.KubernetesModelProcessor
import io.fabric8.kubernetes.generator.annotation.KubernetesProvider

/**
 * Created by swinchester on 6/10/16.
 */
class Generator{

    @KubernetesProvider("stuff.yaml")
    public KubernetesList buildList() {

        return new KubernetesListBuilder().addNewPersistentVolumeItem()
                .withNewMetadata()
                .withName("typesafe-kubernetes-dsl-pv")
                .addToLabels("provider", "fabric8")
                .addToLabels("project", "typesafe-kubernetes-dsl")
                .addToLabels("group", "demo")
                .endMetadata()
                .withNewSpec()
                .addToCapacity("storage", new Quantity("100Ki"))
                .addToAccessModes("ReadWriteOnce")
                .withHostPath(new HostPathVolumeSource("/home/vagrant/camel"))
                .endSpec()
                .endPersistentVolumeItem()
                .build();
    }

    @KubernetesProvider("foo.json")
    public KubernetesList create() {
        return new KubernetesListBuilder()
                .addNewReplicationControllerItem()
                .withNewMetadata()
                .withName("Hello-Controller")
                .endMetadata()
                .withNewSpec()
                .withReplicas(1)
                .addToSelector("component", "my-component")
                .withNewTemplate()
                .withNewSpec()
                .addNewContainer()
                .withName("my-container")
                .withImage("my/image")
                .endContainer()
                .endSpec()
                .endTemplate()
                .endSpec()
                .endReplicationControllerItem()
                .build();
    }

}
